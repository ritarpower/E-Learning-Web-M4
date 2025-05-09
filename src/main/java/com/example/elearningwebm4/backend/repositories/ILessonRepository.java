package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILessonRepository extends JpaRepository<Lessons, Long> {
    List<Lessons> findByCourseCourseId(Long courseCourseId);
}

