package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToursRepo extends JpaRepository<Tours, Integer> {
    @Query("SELECT t.name, t.countries.name FROM Sale s " +
            "JOIN Tours t ON s.tours.id = t.id " +
            "JOIN Clients c ON s.clients.id = c.id " +
            "WHERE c.id = :clientId")
    List<String> findToursByClientId(@Param("clientId") Integer clientId);

    @Query("SELECT h.name FROM Hotels h " +
            "JOIN ToursHotels th ON h.id = th.id.hotels.id " +
            "WHERE th.id.tours.id = :tourId")
    List<String> getHotelsByTourId(@Param("tourId") Integer tourId);

}
