package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Quizzes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quizzes, Long> {
}
