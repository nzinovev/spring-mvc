package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class MyListener {

    public void listen(String string) {
        System.out.println("Message from the queue: " + string);
    }
}
