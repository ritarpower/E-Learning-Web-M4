package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.Lessons;
import com.example.elearningwebm4.backend.repositories.ILessonRepository;
import com.example.elearningwebm4.backend.services.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonsServiceImpl implements LessonsService {

    @Autowired
    private ILessonRepository lessonRepository;

    @Override
    public List<Lessons> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lessons findById(Long id) {
        Optional<Lessons> optionalLessons = lessonRepository.findById(id);
        return optionalLessons.orElse(null);
    }

    @Override
    public Lessons save(Lessons lessons) {
        return lessonRepository.save(lessons);
    }

    @Override
    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public List<Lessons> findByCourseId(Long courseId) {
        return lessonRepository.findByCourseCourseId(courseId);
    }
}