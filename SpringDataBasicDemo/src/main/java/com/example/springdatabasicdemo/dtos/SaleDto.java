package com.example.springdatabasicdemo.dtos;


import java.util.Date;

public class SaleDto {
    private int id;
    private ClientsDto clients;
    private ToursDto tours;

    private Date date;

    public SaleDto(int id, ClientsDto clients, ToursDto tours, Date date) {
        this.id = id;
        this.clients = clients;
        this.tours = tours;
        this.date = date;
    }

    public SaleDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientsDto getClients() {
        return clients;
    }

    public void setClients(ClientsDto clients) {
        this.clients = clients;
    }

    public ToursDto getTours() {
        return tours;
    }

    public void setTours(ToursDto tours) {
        this.tours = tours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SaleDto{" +
                "id=" + id +
                ", clients=" + clients +
                ", tours=" + tours +
                ", date=" + date +
                '}';
    }
}
