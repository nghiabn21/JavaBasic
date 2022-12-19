package com.example.token.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Login {
    private String account;
    private String password;

    public Login(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
