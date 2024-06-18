package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.List;

@Entity
@Table(name = "clients")
public class Clients extends BaseEntity {
    @Column(nullable = false)
    private String name;

    private String phonenumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clients", cascade = CascadeType.ALL)

    private List<Sale> sale;

    public Clients(String name, String phonenumber, List<Sale> sale) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.sale = sale;
    }


    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Clients(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public List<Sale> getSale() {
        return sale;
    }

    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sale=" + sale +
                ", id=" + id +
                '}';
    }
}
