package com.example.service;

import com.example.domain.dto.UserDto;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto doSomeLogicWithThisUser(UserDto dto) {
        return userRepository.findUserById(dto.getId());
    }
}
