package com.example.springdatabasicdemo.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Integer id) {
        super("Could not find country " + id);
    }

}
