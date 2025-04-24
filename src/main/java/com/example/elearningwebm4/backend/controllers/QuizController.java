package com.example.elearningwebm4.backend.controllers;


import com.example.elearningwebm4.backend.models.Quizzes;
import com.example.elearningwebm4.backend.services.serviceimpl.QuizzesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizzesServiceImpl quizService;

    // List all quizzes
    @GetMapping
    public String listQuizzes(Model model) {
        model.addAttribute("quizzes", quizService.getAllQuizzes());
        return "/quizzes/list"; // Thymeleaf template: list.html
    }

    // Show form to create a new quiz
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("quiz", new Quizzes());
        return "/quizzes/form"; // Thymeleaf template: form.html
    }

    // Save a new quiz
    @PostMapping
    public String createQuiz(@ModelAttribute Quizzes quiz) {
        quizService.createQuiz(quiz);
        return "redirect:/quizzes";
    }

    // Show form to edit an existing quiz
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Quizzes quiz = quizService.getQuizById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        model.addAttribute("quiz", quiz);
        return "/quizzes/form"; // Reuse form.html for editing
    }

    // Update an existing quiz
    @PostMapping("/update/{id}")
    public String updateQuiz(@PathVariable Long id, @ModelAttribute Quizzes quiz) {
        quizService.updateQuiz(id, quiz);
        return "redirect:/quizzes";
    }

    // Delete a quiz
    @GetMapping("/delete/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return "redirect:/quizzes";
    }
}
