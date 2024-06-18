package com.example.springdatabasicdemo.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Integer id) {
        super("Could not find client " + id);
    }
}
