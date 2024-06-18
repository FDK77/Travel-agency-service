package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Hotels;
import com.example.springdatabasicdemo.models.Tours;
import com.example.springdatabasicdemo.models.ToursHotels;
import com.example.springdatabasicdemo.models.ToursHotelsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToursHotelsRepo extends JpaRepository<ToursHotels, ToursHotelsId> {
}
