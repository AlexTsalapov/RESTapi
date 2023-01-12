package com.example.RESTapi.exception;

import lombok.Data;


public class UserAlreadyExistExeption extends Exception {
    public UserAlreadyExistExeption(String message) {
        super(message);
    }
}
