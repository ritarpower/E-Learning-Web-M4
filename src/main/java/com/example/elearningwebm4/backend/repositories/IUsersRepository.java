package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
