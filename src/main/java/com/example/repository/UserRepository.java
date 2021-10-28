package com.example.repository;

import com.example.domain.entity.User;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<User> findUsers(String login, String email, int age) {

        CompletableFuture<List<User>> usersWithSameLogin =
                CompletableFuture.supplyAsync(() -> users.stream().filter(user -> user.getLogin().equals(login)).collect(Collectors.toList()));
        CompletableFuture<List<User>> usersWithSameEmail =
                CompletableFuture.supplyAsync(() -> users.stream().filter(user -> user.getEmail().equals(email)).collect(Collectors.toList()));
        CompletableFuture<List<User>> userWithSameAge =
                CompletableFuture.supplyAsync(() -> users.stream().filter(user -> user.getAge() == age).collect(Collectors.toList()));

        return Stream.of(usersWithSameLogin, usersWithSameEmail, userWithSameAge)
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
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
