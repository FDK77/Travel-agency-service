package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.*;
import com.example.springdatabasicdemo.services.ToursHotelsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToursHotelsServiceImpl implements ToursHotelsService<Integer> {

    @Autowired
    private HotelsRepo hotelsRepo;

    @Autowired
    private ToursRepo toursRepo;

    @Autowired
    private ToursHotelsRepo toursHotelsRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ToursHotelDto register(ToursHotelDto toursHotelDto) {
        ToursHotels t = modelMapper.map(toursHotelDto, ToursHotels.class);
        if (toursHotelDto.getTours().getId() != 0) {
            Tours ts = toursRepo.findById(toursHotelDto.getTours().getId()).get();
            t.getId().setTours(ts);
        }
        if (toursHotelDto.getHotels().getId() != 0) {
            Hotels h = hotelsRepo.findById(toursHotelDto.getHotels().getId()).get();
            t.getId().setHotels(h);
        }
        return modelMapper.map(toursHotelsRepo.save(t), ToursHotelDto.class);
    }


    @Override
    public List<ToursHotelsIdDto> getAll() {
        List<ToursHotels> toursHotelsList = toursHotelsRepo.findAll();

        List<ToursHotelsIdDto> toursHotelDtoIdList = new ArrayList<>();
        for (ToursHotels toursHotels : toursHotelsList) {
            ToursHotelDto toursHotelDto = modelMapper.map(toursHotels, ToursHotelDto.class);
            toursHotelDtoIdList.add(toursHotelDto.getId());
        }

        return toursHotelDtoIdList;
    }


    @Override
    public void delete(Integer idTour, Integer idHotel) {
        Tours ts = toursRepo.findById(idTour).get();
        Hotels ht = hotelsRepo.findById(idHotel).get();
        toursHotelsRepo.deleteById(new ToursHotelsId(ts,ht));
    }


}
