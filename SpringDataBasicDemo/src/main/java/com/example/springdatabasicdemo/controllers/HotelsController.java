package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.exceptions.HotelNotFoundException;
import com.example.springdatabasicdemo.services.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelsController {
    @Autowired
    private HotelsService hotelsService;

    @PostMapping("/hotels/update")
    HotelsDto updateHotel(@RequestBody HotelsDto newHotel) {  return hotelsService.register(newHotel); }

    @PostMapping("/hotels/register")
    HotelsDto newHotel(@RequestBody HotelsDto newHotel) {  return hotelsService.register(newHotel); }

    @GetMapping("/hotels")
    Iterable<HotelsDto> allHotels() {
        return hotelsService.getAll();
    }

    @GetMapping("/hotels/find/{id}")
    HotelsDto oneHotel(@PathVariable Integer id) throws Throwable {
        return (HotelsDto) hotelsService.findHotels(id).orElseThrow(() -> new HotelNotFoundException(id)); // Переделать
    }

    @DeleteMapping("/hotels/delete/{id}")
    void deleteHotel(@PathVariable Integer id) {
        hotelsService.delete(id);
    }

    @GetMapping("/hotels/findHotelsByCountry/{name}")
    List<String> findHotelsByCountry(@PathVariable String name){
        return hotelsService.findHotelsByCountryName(name);
    }
}
