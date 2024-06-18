package com.example.springdatabasicdemo.dtos;



public class CountriesDto {
    private String name;
    private int id;

    public CountriesDto(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public CountriesDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CountriesDto{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
