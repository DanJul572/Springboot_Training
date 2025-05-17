package com.example.training.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReq {
    private String email;
    private String password;

    public LoginReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
