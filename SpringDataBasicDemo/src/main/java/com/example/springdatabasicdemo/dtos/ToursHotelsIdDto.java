package com.example.springdatabasicdemo.dtos;

public class ToursHotelsIdDto {
    private ToursDto tours;
    private HotelsDto hotels;

    public ToursHotelsIdDto(ToursDto tours, HotelsDto hotels) {
        this.tours = tours;
        this.hotels = hotels;
    }

    public ToursHotelsIdDto() {
    }

    public ToursDto getTours() {
        return tours;
    }

    public void setTours(ToursDto tours) {
        this.tours = tours;
    }

    public HotelsDto getHotels() {
        return hotels;
    }

    public void setHotels(HotelsDto hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "ToursHotelsIdDto{" +
                "tours=" + tours +
                ", hotels=" + hotels +
                '}';
    }
}
