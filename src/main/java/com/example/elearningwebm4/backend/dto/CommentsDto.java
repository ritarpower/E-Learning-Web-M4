package com.example.elearningwebm4.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
    private Long commentId;
    private Long userId;
    private Long courseId;
    private String content;
    private LocalDateTime createdAt;
}