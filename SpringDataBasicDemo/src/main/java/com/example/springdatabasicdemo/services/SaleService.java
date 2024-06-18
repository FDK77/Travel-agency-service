package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.SaleDto;

import java.util.List;
import java.util.Optional;

public interface SaleService <ID> {

    SaleDto register(SaleDto sale);

    void delete(SaleDto sale);

    void delete(ID id);

    List<SaleDto> getAll();

    Optional<SaleDto> findSale(ID id);
}
