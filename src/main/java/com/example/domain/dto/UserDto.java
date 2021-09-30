package com.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class UserDto {

    //todo: 3. Not mandatory. A test of attentiveness. What is redundant in UserDTO and user models?

    String id;
    String login;
    String email;
}

