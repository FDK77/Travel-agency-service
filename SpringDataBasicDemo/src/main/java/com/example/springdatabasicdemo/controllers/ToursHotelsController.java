package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.dtos.ToursHotelDto;
import com.example.springdatabasicdemo.exceptions.HotelNotFoundException;
import com.example.springdatabasicdemo.services.HotelsService;
import com.example.springdatabasicdemo.services.ToursHotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToursHotelsController {
    @Autowired
    private ToursHotelsService toursHotelsService;

    @PostMapping("/tourhotel/register")
    ToursHotelDto newTH(@RequestBody ToursHotelDto newToursHotel) {  return toursHotelsService.register(newToursHotel); }

    @GetMapping("/tourhotel")
    Iterable<ToursHotelDto> allTH() {
        return toursHotelsService.getAll();
    }

    @DeleteMapping("/tourhotel/delete/{idTour},{idHotel}")
    void deleteStudent(@PathVariable Integer idTour, @PathVariable Integer idHotel) {
        toursHotelsService.delete(idTour,idHotel);
    }

    @PostMapping("/tourhotel/update")
    ToursHotelDto updateTH(@RequestBody ToursHotelDto newToursHotel) {  return toursHotelsService.register(newToursHotel); }
}
