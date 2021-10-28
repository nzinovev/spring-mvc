package com.example.domain.dto;

import com.example.domain.entity.User;
import lombok.Getter;

@Getter
public class UserDto {

    private String login;
    private String email;
    private int age;
    private String password;
    private String confirmPassword;

    public UserDto(User user) {
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.age = user.getAge();
    }
}

