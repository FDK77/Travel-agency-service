package com.example.springdatabasicdemo.exceptions;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException(Integer id) {
        super("Could not find tour " + id);
    }

}
