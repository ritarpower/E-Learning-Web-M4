package com.example.elearningwebm4.backend.services;

import com.example.elearningwebm4.backend.models.Lessons;

import java.util.List;

public interface LessonsService {
    List<Lessons> findAll();
    Lessons findById(Long id);
    Lessons save(Lessons lessons);
    void deleteById(Long id);
    List<Lessons> findByCourseId(Long courseId);
}
