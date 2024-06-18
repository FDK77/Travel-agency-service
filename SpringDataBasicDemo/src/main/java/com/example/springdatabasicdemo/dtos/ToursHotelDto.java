package com.example.springdatabasicdemo.dtos;


public class ToursHotelDto {

    private ToursHotelsIdDto id;
    private ToursDto tours;
    private HotelsDto hotels;

    public ToursHotelDto(ToursHotelsIdDto id, ToursDto tours, HotelsDto hotels) {
        this.id = id;
        this.tours = tours;
        this.hotels = hotels;
    }

    public ToursHotelDto() {
    }


    public ToursHotelsIdDto getId() {
        return id;
    }

    public void setId(ToursHotelsIdDto id) {
        this.id = id;
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
        return "ToursHotelDto{" +
                "id=" + id +
                ", tours=" + tours +
                ", hotels=" + hotels +
                '}';
    }
}
