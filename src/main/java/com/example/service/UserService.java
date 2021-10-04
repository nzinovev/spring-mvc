package com.example.service;

import com.example.domain.dto.UserDto;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto doSomeLogicWithThisUser(UserDto dto) {
        return userRepository.findUserById(dto.getId());
    }
}
