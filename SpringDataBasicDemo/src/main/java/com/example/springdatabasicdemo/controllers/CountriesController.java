package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.CountriesDto;
import com.example.springdatabasicdemo.exceptions.CountryNotFoundException;
import com.example.springdatabasicdemo.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountriesController {
    @Autowired
    private CountriesService countriesService;

    @PostMapping("/countries/update")
    CountriesDto updateCountry(@RequestBody CountriesDto countriesDto){
        return countriesService.register(countriesDto);
    }
    @GetMapping("/countries")
    Iterable<CountriesDto> allCountries() {
        return countriesService.getAll();
    }

    @PostMapping("/countries/register")
    CountriesDto newCountry(@RequestBody CountriesDto countriesDto) {  return countriesService.register(countriesDto); }

    @GetMapping("/countries/find/{id}")
    CountriesDto oneCountry(@PathVariable Integer id) throws Throwable {
        return (CountriesDto) countriesService.findCountry(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    @GetMapping("/countries/CountOfSalesByCountry/{countryName}")
    Long cosbc(@PathVariable String countryName) throws Throwable {
        return countriesService.getSalesCountByCountryName(countryName);
    }

    @DeleteMapping("/countries/delete/{id}")
    void deleteCountry(@PathVariable Integer id) {
        countriesService.delete(id);
    }
}
