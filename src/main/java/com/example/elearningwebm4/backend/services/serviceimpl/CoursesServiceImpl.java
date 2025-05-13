package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.Courses;
import com.example.elearningwebm4.backend.repositories.ICoursesRepository;
import com.example.elearningwebm4.backend.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private ICoursesRepository coursesRepository;

    @Override
    public Page<Courses> findAllCourses(Pageable pageable) {
        return coursesRepository.findAllCourses(pageable);
    }

    @Override
    public Page<Courses> findCoursesByTitle(String title, Pageable pageable) {
        return coursesRepository.findAllCoursesByTitle(title,pageable);
    }

    @Override
    public void saveCourses(Courses courses) {
        coursesRepository.save(courses);
    }

    @Override
    public Courses findCoursesById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCoursesById(Long id) {
        coursesRepository.deleteById(id);
    }

    public Optional<Courses> findById(Long courseId) {
        return coursesRepository.findById(courseId);
    }
}