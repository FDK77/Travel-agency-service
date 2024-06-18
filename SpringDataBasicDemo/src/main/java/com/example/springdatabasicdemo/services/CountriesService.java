package com.example.springdatabasicdemo.services;


import com.example.springdatabasicdemo.dtos.CountriesDto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountriesService<ID> {

    CountriesDto register(CountriesDto countries);

    void delete(CountriesDto countries);

    void delete(ID id);

    List<CountriesDto> getAll();

    Optional<CountriesDto> findCountry(ID id);

    Long getSalesCountByCountryName(String countryName);

}
