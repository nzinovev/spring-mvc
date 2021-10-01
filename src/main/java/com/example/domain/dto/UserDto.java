package com.example.domain.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

    String id;
    String login;
    String email;
}

