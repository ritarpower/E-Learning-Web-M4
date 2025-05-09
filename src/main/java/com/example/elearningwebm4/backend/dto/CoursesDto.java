package com.example.elearningwebm4.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDto {
    private Long courseId;
    private String title;
    private String description;
    private int enrollmentCount;
    private Double price;
//    private LocalDateTime createAt;
//    private LocalDateTime updateAt;
}