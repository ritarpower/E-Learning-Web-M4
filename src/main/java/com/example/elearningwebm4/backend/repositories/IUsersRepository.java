package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByUserId(Long userId);

    @Query("SELECT u FROM Users u")
    Page<Users> findAllUsers(Pageable pageable);

    @Query("SELECT u FROM Users u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Users> findByNameContaining(String name, Pageable pageable);
}
