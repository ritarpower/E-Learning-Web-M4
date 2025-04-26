package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
