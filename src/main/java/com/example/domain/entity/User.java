package com.example.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fancy-id")
    private String uuid;

    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;
}
