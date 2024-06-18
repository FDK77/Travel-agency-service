package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.CountriesDto;
import com.example.springdatabasicdemo.models.Countries;
import com.example.springdatabasicdemo.repositories.CountriesRepo;
import com.example.springdatabasicdemo.services.CountriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountriesServiceImpl implements CountriesService<Integer> {
    @Autowired
    private CountriesRepo countriesRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CountriesDto register(CountriesDto countries) {
        Countries c = modelMapper.map(countries, Countries.class);
        return modelMapper.map(countriesRepo.save(c), CountriesDto.class);
    }

    @Override
    public void delete(CountriesDto countries) {
        countriesRepo.deleteById(countries.getId());
    }

    @Override
    public void delete(Integer id) {
        countriesRepo.deleteById(id);
    }

    @Override
    public List<CountriesDto> getAll() {
        return countriesRepo.findAll().stream().map((c) -> modelMapper.map(c, CountriesDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<CountriesDto> findCountry(Integer id) {
        return Optional.ofNullable(modelMapper.map(countriesRepo.findById(id), CountriesDto.class));
    }

    @Override
    public Long getSalesCountByCountryName(String countryName) {
        return countriesRepo.getSalesCountByCountryName(countryName);
    }
}
