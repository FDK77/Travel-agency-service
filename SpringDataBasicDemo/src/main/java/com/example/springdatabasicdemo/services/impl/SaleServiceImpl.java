package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.ClientsRepo;
import com.example.springdatabasicdemo.repositories.SaleRepo;
import com.example.springdatabasicdemo.repositories.ToursRepo;
import com.example.springdatabasicdemo.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService<Integer> {

    @Autowired
    private SaleRepo saleRepo;

    @Autowired
    private ClientsRepo clientsRepo;

    @Autowired
    private ToursRepo toursRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public SaleDto register(SaleDto saleDto) {
        Sale s = modelMapper.map(saleDto, Sale.class);
        if (saleDto.getClients().getId() != 0) {
            Clients c = clientsRepo.findById(saleDto.getClients().getId()).get();
            s.setClients(c);
        }
        if (saleDto.getTours().getId() != 0) {
            Tours t = toursRepo.findById(saleDto.getTours().getId()).get();
            s.setTours(t);
        }
        return modelMapper.map(saleRepo.save(s), SaleDto.class);
    }

    @Override
    public void delete(SaleDto sale) {
        saleRepo.deleteById(sale.getId());
    }

    @Override
    public void delete(Integer id) {
        saleRepo.deleteById(id);
    }

    @Override
    public List<SaleDto> getAll() {
        return saleRepo.findAll().stream().map((s) -> modelMapper.map(s, SaleDto.class)).collect(Collectors.toList());
    }
    @Override
    public Optional<SaleDto> findSale(Integer id) {
        return Optional.ofNullable(modelMapper.map(saleRepo.findById(id), SaleDto.class));
    }
}
