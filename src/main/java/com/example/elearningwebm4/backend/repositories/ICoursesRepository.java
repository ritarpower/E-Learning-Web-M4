package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICoursesRepository extends JpaRepository<Courses, Long> {

    @Query("SELECT c FROM Courses c")
    Page<Courses> findAllCourses(Pageable pageable);

    @Query("SELECT c FROM Courses c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    Page<Courses> findAllCoursesByTitle(@Param("title") String title, Pageable pageable);
}