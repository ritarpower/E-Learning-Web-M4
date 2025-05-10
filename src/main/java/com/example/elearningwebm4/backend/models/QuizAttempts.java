package com.example.elearningwebm4.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quiz_attempts")
public class QuizAttempts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attempt_id")
    private Long attemptId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quizzes quiz;

    @Column(name = "score", nullable = false)
    private Double score;

    @Column(name = "attempt_date", nullable = false)
    private LocalDateTime attemptDate;
}
