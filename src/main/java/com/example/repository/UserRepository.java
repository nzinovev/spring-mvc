package com.example.repository;

import com.example.domain.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    public UserDto findUserById(String id) {
        return UserDto.builder()
                .id(Optional.ofNullable(id).orElse("new id"))
                .email("email@someMailbox.com")
                .login("Destroyer3000").build();
    }
}
