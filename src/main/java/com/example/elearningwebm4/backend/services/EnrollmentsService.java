package com.example.elearningwebm4.backend.services;

import com.example.elearningwebm4.backend.models.Enrollments;

public interface EnrollmentsService {
//    boolean hasEnrollment(Long userId, Long courseId);
    Enrollments getEnrollment(Long userId, Long courseId);
}
