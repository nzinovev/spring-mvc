package com.example.service;

import com.example.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

//    public void listenUser(String string) {
//        System.out.println("Message from the queue: " + string);
//    }

    @RabbitListener(queues = "myQueue")
    public void listenUser(User user) {
        System.out.println("Message from the queue: " + user.getId() + " " + user.getLogin() + " " + user.getEmail());
    }
}
