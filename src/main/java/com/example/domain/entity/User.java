package com.example.domain.entity;

import com.example.domain.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
//@Table(name = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "login")
    private String login;
//    @Column(name = "email")
    private String email;
//    @Column(name = "password")
    private String password;
//    @Column(name = "age")
    private int age;

    public User() {}

    public User(UserDto dto) {
        this.login = dto.getLogin();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.age = dto.getAge();
    }
}
