package com.example.springdatabasicdemo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tours_hotels")
public class ToursHotels {
    @EmbeddedId
    private ToursHotelsId id;

    protected ToursHotels() {
    }

    public ToursHotels(ToursHotelsId id) {
        this.id = id;
    }

    public ToursHotelsId getId() {
        return id;
    }

    public void setId(ToursHotelsId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToursHotels{" +
                "id=" + id +
                '}';
    }
}
