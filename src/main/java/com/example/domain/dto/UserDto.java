package com.example.domain.dto;

import com.example.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {

    @NotBlank
    @Size(min = 3, max = 20)
    private String login;
    @Email
    @Size(max = 50)
    private String email;
//    @NotBlank
//    @Size(max = 90)
    private int age;
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserDto() {}

    public UserDto(User user) {
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.age = user.getAge();
    }
}

