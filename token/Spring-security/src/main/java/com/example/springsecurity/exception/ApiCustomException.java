package com.example.springsecurity.exception;

public class ApiCustomException extends RuntimeException {

    public ApiCustomException(String s){
        super(s);
    }
}
