package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClientsDto;

import java.util.List;
import java.util.Optional;

public interface ClientsService<ID> {
    ClientsDto register(ClientsDto clients);

    void delete(ClientsDto clients);

    void delete(ID id);

    List<ClientsDto> getAll();

    Optional<ClientsDto> findClient(ID id);

}
