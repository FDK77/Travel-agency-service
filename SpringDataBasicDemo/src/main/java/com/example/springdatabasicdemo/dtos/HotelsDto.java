package com.example.springdatabasicdemo.dtos;



public class HotelsDto {
    private int id;
    private String name;
    private String address;
    private Integer rating;

    public HotelsDto() {
    }

    public HotelsDto(int id, String name, String address, Integer rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
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

    @Override
    public String toString() {
        return "HotelsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", rating=" + rating +
                '}';
    }
}
