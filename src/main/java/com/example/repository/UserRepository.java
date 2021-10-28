package com.example.repository;

import com.example.domain.entity.User;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserRepository {

    private List<User> users = fillUsers();

    public List<User> findUsers() {
        return users;
    }

    public void createUser(User user) {
        users.add(user);
    }

    public void clean() {
        users.clear();
    }

    private List<User> fillUsers() {
        users = new ArrayList<>();
        var random = new Random();
        for (int i = 0; i < 5; i++) {
            var user = new User();
            user.setEmail(StringUtils.randomAlphanumeric(5) + "@gmail.com");
            user.setLogin(StringUtils.randomAlphanumeric(10));
            user.setAge((int) random.ints(99L, 10, 99).average().orElse(10.0));
            users.add(user);
        }
        return users;
    }
}
