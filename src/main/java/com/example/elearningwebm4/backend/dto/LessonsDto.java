package com.example.elearningwebm4.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonsDto {
    private Long lessonId;
    private Long courseId;
    private String title;
    private String content;
    private String videoUrl;
    private int orderIndex;
}
