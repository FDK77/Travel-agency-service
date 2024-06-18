package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tours")
public class Tours extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date startdate;
    @Column(nullable = false)
    private Date enddate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable=false)
    private Countries countries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tours", cascade = CascadeType.ALL)
    private List<Sale> sale;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.tours",cascade = CascadeType.ALL)
    private List<ToursHotels> toursHotels;

    protected Tours() {
    }

    public Tours(String name, Date startdate, Date enddate, Countries countries, List<Sale> sale, List<ToursHotels> toursHotels) {
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.countries = countries;
        this.sale = sale;
        this.toursHotels = toursHotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public List<Sale> getSale() {
        return sale;
    }

    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    public List<ToursHotels> getToursHotels() {
        return toursHotels;
    }

    public void setToursHotels(List<ToursHotels> toursHotels) {
        this.toursHotels = toursHotels;
    }

    @Override
    public String toString() {
        return "Tours{" +
                "name='" + name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", countries=" + countries +
                ", sale=" + sale +
                ", toursHotels=" + toursHotels +
                ", id=" + id +
                '}';
    }
}
