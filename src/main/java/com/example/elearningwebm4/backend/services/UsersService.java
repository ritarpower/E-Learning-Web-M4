package com.example.elearningwebm4.backend.services;

import com.example.elearningwebm4.backend.models.Users;

public interface UsersService {
    Users findByEmail(String email);
}
