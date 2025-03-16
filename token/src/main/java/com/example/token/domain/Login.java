package com.example.token.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Login {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String account;
    private String password;

    public Login(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
