package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email); // Thay đổi từ Users sang Optional<Users>
}
