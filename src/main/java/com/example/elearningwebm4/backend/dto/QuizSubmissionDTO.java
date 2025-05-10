package com.example.elearningwebm4.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class QuizSubmissionDTO {
    private Long quizId;
    private Map<Long, String> answers = new HashMap<>(); // Key: questionId, Value: selected answer (A, B, C, D)
}