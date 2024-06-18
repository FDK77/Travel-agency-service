package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepo extends JpaRepository<Clients, Integer> {
}
