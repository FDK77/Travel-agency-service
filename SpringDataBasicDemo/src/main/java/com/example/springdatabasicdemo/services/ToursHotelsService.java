package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.*;

import java.util.List;
import java.util.Optional;

public interface ToursHotelsService <ID> {
    ToursHotelDto register(ToursHotelDto toursHotelDto);

    List<ToursHotelsIdDto> getAll();

    void delete(Integer id, Integer id1);

}
