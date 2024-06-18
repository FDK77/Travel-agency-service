package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.ToursDto;

import java.util.List;
import java.util.Optional;

public interface ToursService<ID> {
    ToursDto register(ToursDto tours);

    void delete(ToursDto tours);

    void delete(ID id);

    List<ToursDto> getAll();

    Optional<ToursDto> findTours(ID id);

    List<String> getHotelsByTourId(Integer tourId);

    List<String> findToursByClientId(Integer id);
}
