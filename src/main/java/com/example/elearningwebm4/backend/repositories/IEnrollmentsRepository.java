package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Courses;
import com.example.elearningwebm4.backend.models.Enrollments;
import com.example.elearningwebm4.backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnrollmentsRepository extends JpaRepository<Enrollments, Long> {
    boolean existsByCourseAndUser(Courses courses, Users users);
}
