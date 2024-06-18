package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ClientsDto;
import com.example.springdatabasicdemo.models.Clients;
import com.example.springdatabasicdemo.repositories.ClientsRepo;
import com.example.springdatabasicdemo.services.ClientsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClientsServiceImpl implements ClientsService<Integer> {
    @Autowired
    private ClientsRepo clientsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientsDto register(ClientsDto clients) {
        Clients c = modelMapper.map(clients, Clients.class);
        return modelMapper.map(clientsRepo.save(c), ClientsDto.class);    }

    @Override
    public void delete(ClientsDto clients) {
        clientsRepo.deleteById(clients.getId());
    }

    @Override
    public void delete(Integer id) {
        clientsRepo.deleteById(id);
    }

    @Override
    public List<ClientsDto> getAll() {
        return clientsRepo.findAll().stream().map((c) -> modelMapper.map(c, ClientsDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientsDto> findClient(Integer id) {
        return Optional.ofNullable(modelMapper.map(clientsRepo.findById(id), ClientsDto.class));
    }
}
