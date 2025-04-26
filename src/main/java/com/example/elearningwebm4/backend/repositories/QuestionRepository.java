package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions, Long> {
    List<Questions> findByQuizQuizId(Long quizId);
}
