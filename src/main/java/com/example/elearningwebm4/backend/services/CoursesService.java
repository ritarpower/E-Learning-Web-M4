package com.example.elearningwebm4.backend.services;

import com.example.elearningwebm4.backend.models.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoursesService {
    Page<Courses> findAllCourses(Pageable pageable);
    Page<Courses> findCoursesByTitle(String title, Pageable pageable);
    void saveCourses(Courses courses);
    Courses findCoursesById(Long id);
    void deleteCoursesById(Long id);
}
