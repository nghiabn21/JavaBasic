package com.example.token.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String s) {
        super(s);
    }
}
