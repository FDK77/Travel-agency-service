package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelsRepo extends JpaRepository<Hotels, Integer> {
    @Query("select c.name, h.name, h.address from Countries c join Tours t on c.id = t.countries.id" +
            " join ToursHotels th on t.id=th.id.tours.id join Hotels h on h.id=th.id.hotels.id"+
            " where c.name = :countryName")
    List<String> findHotelsByCountryName(@Param("countryName") String countryName);
}
