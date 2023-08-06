package com.example.InstaCopy.payload.response.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {
    @NotEmpty(message = "Username cannot be empty!")
    private String username;
    @NotEmpty(message = "Username cannot be empty!")

    private String password;


}