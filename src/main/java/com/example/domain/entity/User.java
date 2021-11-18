package com.example.domain.entity;

import com.example.domain.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String login;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private int age;

    public User() {}

    public User(UserDto dto) {
        this.login = dto.getLogin();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.age = dto.getAge();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
