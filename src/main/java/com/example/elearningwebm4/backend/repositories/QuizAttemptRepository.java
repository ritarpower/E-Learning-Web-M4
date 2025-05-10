package com.example.elearningwebm4.backend.repositories;


import com.example.elearningwebm4.backend.models.QuizAttempts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempts, Long> {
    List<QuizAttempts> findByUserUserIdAndQuizQuizId(Long userId, Long quizId);
}
