package com.example.elearningwebm4.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResultsDto {
    private Long resultId;
    private Long userId;
    private Long quizId;
    private double score;
    private LocalDateTime submittedAt;
}