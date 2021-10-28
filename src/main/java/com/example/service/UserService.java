package com.example.service;

import com.example.domain.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findUsers() {
        return userRepository.findUsers();
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public void clean() {
        userRepository.clean();
    }

    public List<User> findUsers(String login, String email, int age) {
        return userRepository.findUsers(login, email, age);
    }
}
