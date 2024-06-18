package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.HotelsDto;

import java.util.List;
import java.util.Optional;

public interface HotelsService<ID>{
    HotelsDto register(HotelsDto hotels);

    void delete(HotelsDto hotels);

    void delete(ID id);

    List<HotelsDto> getAll();

    Optional<HotelsDto> findHotels(ID id);
    List<String> findHotelsByCountryName(String name);
}

