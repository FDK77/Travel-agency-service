package com.example.springdatabasicdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Entity
@Table(name = "sale")
public class Sale extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable=false)
    private Clients clients;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tour_id", referencedColumnName = "id", nullable=false)
    private Tours tours;

    private Date date;

    protected Sale() {
    }


    public Sale(Clients clients, Tours tours, Date date) {
        this.clients = clients;
        this.tours = tours;
        this.date = date;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public Tours getTours() {
        return tours;
    }

    public void setTours(Tours tours) {
        this.tours = tours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
