package com.example.springdatabasicdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ToursHotelsId implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "tour_id", referencedColumnName = "id", nullable=false)
    @JsonIgnore //чтобы предотвратить сериализацию циклической связи
    private Tours tours;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable=false)
    @JsonIgnore
    private Hotels hotels;

    public ToursHotelsId(Tours tours, Hotels hotels) {
        this.tours = tours;
        this.hotels = hotels;
    }

    public Tours getTours() {
        return tours;
    }

    public void setTours(Tours tours) {
        this.tours = tours;
    }

    public Hotels getHotels() {
        return hotels;
    }

    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }

    protected ToursHotelsId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToursHotelsId that = (ToursHotelsId) o;
        return Objects.equals(tours, that.tours) && Objects.equals(hotels, that.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tours, hotels);
    }
}
