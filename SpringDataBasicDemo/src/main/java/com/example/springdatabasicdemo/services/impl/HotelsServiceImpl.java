package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.models.Hotels;
import com.example.springdatabasicdemo.repositories.HotelsRepo;
import com.example.springdatabasicdemo.services.HotelsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelsServiceImpl implements HotelsService<Integer> {
    @Autowired
    private HotelsRepo hotelsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelsDto register(HotelsDto hotels) {
        Hotels h = modelMapper.map(hotels, Hotels.class);
        return modelMapper.map(hotelsRepo.save(h), HotelsDto.class);
    }

    @Override
    public void delete(HotelsDto hotels) {
        hotelsRepo.deleteById(hotels.getId());
    }

    @Override
    public void delete(Integer id) {
        hotelsRepo.deleteById(id);
    }


    @Override
    public Optional<HotelsDto> findHotels(Integer id) {
        return Optional.ofNullable(modelMapper.map(hotelsRepo.findById(id), HotelsDto.class));
    }

    @Override
    public List<HotelsDto> getAll() {
        return hotelsRepo.findAll().stream().map((s) -> modelMapper.map(s, HotelsDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<String> findHotelsByCountryName(String name) {
        return hotelsRepo.findHotelsByCountryName(name);
    }

}
