package com.example.InstaCopy.payload.response.request;

import com.example.InstaCopy.annotations.PasswordMatches;
import com.example.InstaCopy.annotations.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches
public class SignupRequest {
    @Email(message = "It should have email format!")
    @NotBlank(message = "User email is required")
    @ValidEmail
    private String email;
    @NotEmpty(message = "Plase enter your firstname")
    private String firstname;
    @NotEmpty(message = "Plase enter your lastname")
    private String lastname;
    @NotEmpty(message = "Plase enter your username")
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(min = 5)
    private String password;
    private String confirmPassword;
}
