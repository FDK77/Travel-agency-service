package com.example.springdatabasicdemo.dtos;


import java.util.Date;

public class ToursDto {
    private int id;

    private String name;

    private Date startdate;

    private Date enddate;

    private CountriesDto countries;

    public ToursDto(int id, String name, Date startdate, Date enddate, CountriesDto countries) {
        this.id = id;
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.countries = countries;
    }

    public ToursDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CountriesDto getCountries() {
        return countries;
    }

    public void setCountries(CountriesDto countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "ToursDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", countries=" + countries +
                '}';
    }
}
