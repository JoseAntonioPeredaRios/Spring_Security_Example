package com.joseapereda.security.utils.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private Set<String> roles;
}