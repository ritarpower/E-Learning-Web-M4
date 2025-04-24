package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnrollments extends JpaRepository<Enrollments, Long> {
}
