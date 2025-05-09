package com.example.elearningwebm4.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long userId;
    private String name;
    private String email;
    private String oldPassword;
    private String password;
    private String confirmPassword;
    private LocalDateTime createAt;
}