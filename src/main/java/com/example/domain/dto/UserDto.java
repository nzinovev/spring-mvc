package com.example.domain.dto;

import com.example.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "Пожалуйста, введите логин")
    @Size(min = 3, max = 20, message = "Логин должен содержать от {min} до {max} символов.")
    private String login;
    @Email
    @Size(max = 50)
    private String email;
    @Max(value = 99)
    @Positive(message = "Должно быть больше нуля")
    private int age;
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;
    @NotBlank
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserDto() {
    }

    public UserDto(User user) {
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.age = user.getAge();
    }
}

