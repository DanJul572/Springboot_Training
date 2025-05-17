package com.example.training.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
