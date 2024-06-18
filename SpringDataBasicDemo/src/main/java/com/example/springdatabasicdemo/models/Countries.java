package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "countries")
public class Countries extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "countries", cascade = CascadeType.REMOVE)
    private List<Tours> tours;

    public Countries(String name, List<Tours> tours) {
        this.name = name;
        this.tours = tours;
    }

    protected Countries() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tours> getTours() {
        return tours;
    }

    public void setTours(List<Tours> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", tours=" + tours +
                ", id=" + id +
                '}';
    }
}
