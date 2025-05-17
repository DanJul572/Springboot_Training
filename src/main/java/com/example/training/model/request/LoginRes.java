package com.example.training.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRes {
    private String email;
    private String token;

    public LoginRes(String email, String token) {
        this.email = email;
        this.token = token;
    }

}
