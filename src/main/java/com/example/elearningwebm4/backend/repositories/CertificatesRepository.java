package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Certificates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificatesRepository extends JpaRepository<Certificates, Long> {
    Optional<Certificates> findByUserUserIdAndCourseCourseId(Long userId, Long courseId);
    List<Certificates> findAllByUserUserId(Long userId);
}