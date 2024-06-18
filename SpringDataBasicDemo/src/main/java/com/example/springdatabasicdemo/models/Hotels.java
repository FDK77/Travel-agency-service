package com.example.springdatabasicdemo.models;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotels extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer rating;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.hotels",cascade = CascadeType.ALL)
    private List<ToursHotels> toursHotels;

    protected Hotels() {
    }

    public Hotels(String name, String address, Integer rating, List<ToursHotels> toursHotels) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.toursHotels = toursHotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<ToursHotels> getToursHotels() {
        return toursHotels;
    }

    public void setToursHotels(List<ToursHotels> toursHotels) {
        this.toursHotels = toursHotels;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", rating=" + rating +
                ", toursHotels=" + toursHotels +
                ", id=" + id +
                '}';
    }
}
