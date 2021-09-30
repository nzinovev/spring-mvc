package com.example.repository;

import com.example.domain.dto.UserDto;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public UserDto findUserById(String id) {
        //todo: 5. Not mandatory. How to handle id with value 'null' without if block?
        return UserDto.builder()
                .id(id)
                .email("email@someMailbox.com")
                .login("Destroyer3000").build();
    }
}
