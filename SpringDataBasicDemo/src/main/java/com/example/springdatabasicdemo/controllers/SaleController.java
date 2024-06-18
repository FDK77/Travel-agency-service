package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.SaleDto;
import com.example.springdatabasicdemo.exceptions.SaleNotFoundException;
import com.example.springdatabasicdemo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping("/sale/update")
    SaleDto updateSale(@RequestBody SaleDto newSale) {  return saleService.register(newSale); }

    @PostMapping("/sale/register")
    SaleDto newSale(@RequestBody SaleDto newSale) {  return saleService.register(newSale); }

    @GetMapping("/sale")
    Iterable<SaleDto> allSale() {
        return saleService.getAll();
    }

    @GetMapping("/sale/find/{id}")
    SaleDto oneSale(@PathVariable Integer id) throws Throwable {
        return (SaleDto) saleService.findSale(id).orElseThrow(() -> new SaleNotFoundException(id));
    }

    @DeleteMapping("/sale/delete/{id}")
    void deleteSale(@PathVariable Integer id) {
        saleService.delete(id);
    }
}
