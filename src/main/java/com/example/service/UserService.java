package com.example.service;

import com.example.domain.dto.UserDto;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> findUsers() {
        return userRepository.findUsers().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }
}
