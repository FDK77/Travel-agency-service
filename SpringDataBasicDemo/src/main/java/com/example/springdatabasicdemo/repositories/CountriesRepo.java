package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepo extends JpaRepository<Countries, Integer> {
    @Query("SELECT COUNT(s) FROM Countries c JOIN Tours t ON c.id = t.countries.id JOIN Sale s ON t.id = s.tours.id WHERE c.name = :countryName")
    Long getSalesCountByCountryName(@Param("countryName") String countryName);
}
