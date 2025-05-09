package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Lessons;
import com.example.elearningwebm4.backend.services.EnrollmentsService;
import com.example.elearningwebm4.backend.services.LessonsService;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonsService lessonsService;

    @Autowired
    private EnrollmentsService enrollmentsService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/topics")
    public String redirectToDefaultCourse() {
        return "redirect:/lessons/topics/1";
    }

    @GetMapping("/topics/{courseId}")
    public String viewLessonTopics(@PathVariable("courseId") Long courseId, Model model) {
        List<Lessons> lessons = lessonsService.findByCourseId(courseId);
        model.addAttribute("lessons", lessons);
        model.addAttribute("courseId", courseId);

        if (courseId == 1) {
            return "lesson/lesson-topics-java";
        } else if (courseId == 2) {
            return "lesson/lesson-topics-js";
        } else if (courseId == 3) {
            return "lesson/lesson-topics-python";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/lesson-detail/{id}")
    public String viewLessonDetail(@PathVariable("id") Long id, Model model) {
        Lessons lesson = lessonsService.findById(id);
        if (lesson == null) {
            return "redirect:/lessons/topics/1";
        }

        Long previousId = id > 1 ? id - 1 : null;
        Long nextId = id + 1;

        model.addAttribute("lesson", lesson);
        model.addAttribute("currentLessonId", id);
        model.addAttribute("previousId", previousId);
        model.addAttribute("nextId", nextId);

        Long courseId = lesson.getCourse().getCourseId();
        model.addAttribute("courseId", courseId);

        if (courseId == 1) {
            return "lesson/lesson-detail-java";
        } else if (courseId == 2) {
            return "lesson/lesson-detail-js";
        } else if (courseId == 3) {
            return "lesson/lesson-detail-python";
        } else {
            return "redirect:/";
        }
    }
}
