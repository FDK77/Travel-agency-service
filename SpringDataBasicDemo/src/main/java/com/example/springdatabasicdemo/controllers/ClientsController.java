package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ClientsDto;
import com.example.springdatabasicdemo.exceptions.ClientNotFoundException;
import com.example.springdatabasicdemo.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class ClientsController {
    @Autowired
    private ClientsService clientsService;

    @PostMapping("/clients/update")
    ClientsDto updateClients(@RequestBody ClientsDto clientsDto){
        return clientsService.register(clientsDto);
    }
    @GetMapping("/clients")
    Iterable<ClientsDto> allClients() {
        return clientsService.getAll();
    }

    @PostMapping("/clients/register")
    ClientsDto newClients(@RequestBody ClientsDto clientsDto) {  return clientsService.register(clientsDto); }

    @GetMapping("/clients/{id}")
    ClientsDto oneClients(@PathVariable Integer id) throws Throwable {
        return (ClientsDto) clientsService.findClient(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @DeleteMapping("/clients/{id}")
    void deleteClients(@PathVariable Integer id) {
        clientsService.delete(id);
    }
}
