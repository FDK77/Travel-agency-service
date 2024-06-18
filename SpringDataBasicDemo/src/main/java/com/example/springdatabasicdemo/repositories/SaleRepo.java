package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Integer> {
}
