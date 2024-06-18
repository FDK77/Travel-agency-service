package com.example.springdatabasicdemo.controllers;
import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.ToursDto;
import com.example.springdatabasicdemo.exceptions.TourNotFoundException;
import com.example.springdatabasicdemo.services.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ToursController {
    @Autowired
    private ToursService toursService;

    @PostMapping("/tours/update")
    ToursDto updateTour(@RequestBody ToursDto toursDto) {
        return toursService.register(toursDto);
    }

    @GetMapping("/tours")
    Iterable<ToursDto> allTours() {
        return toursService.getAll();
    }

    @PostMapping("/tours/register")
    ToursDto newTour(@RequestBody ToursDto toursDto) {
        return toursService.register(toursDto);
    }

    @GetMapping("/tours/find/{id}")
    ToursDto oneTour(@PathVariable Integer id) throws Throwable {
        return (ToursDto) toursService.findTours(id)
                .orElseThrow(() -> new TourNotFoundException(id));
    }

    @DeleteMapping("/tours/delete/{id}")
    void deleteTour(@PathVariable Integer id) {
        toursService.delete(id);
    }

    @GetMapping("/tours/findHotels/{id}")
    public List<String> getHotelsByTourId(@PathVariable Integer id) {
        return toursService.getHotelsByTourId(id);
    }

    @GetMapping("/tours/ByClientId/{id}")
    public List<String> getToursByClientId(@PathVariable Integer id) {
        return toursService.findToursByClientId(id);
    }
}
