package com.example.elearningwebm4.backend.services;

import com.example.elearningwebm4.backend.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsersService {
    Users findByEmail(String email);
    Users findByUserId(Long userId);
    Page<Users> findAllUsers(Pageable pageable);
    Page<Users> findByNameContaining(String name, Pageable pageable);
    void saveUser(Users user);
//    void deleteUserById(Long userId);
    void changeStatusUserById(Long userId);
}
