package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Questions;
import com.example.elearningwebm4.backend.models.Quizzes;
import com.example.elearningwebm4.backend.services.serviceimpl.QuestionsServiceImpl;
import com.example.elearningwebm4.backend.services.serviceimpl.QuizzesServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questions")
@PreAuthorize("hasRole('ADMIN')")
public class QuestionController {

    @Autowired
    private QuestionsServiceImpl questionService;

    @Autowired
    private QuizzesServiceImpl quizService;

    // List all questions for a specific quiz
    @GetMapping("/quiz/{quizId}")
    public String listQuestions(@PathVariable Long quizId, Model model) {
        model.addAttribute("questions", questionService.getQuestionsByQuizId(quizId));
        model.addAttribute("quizId", quizId);
        return "/questions/list";
    }

    // Show form to create a new question
    @GetMapping("/new/{quizId}")
    public String showCreateForm(@PathVariable Long quizId, Model model) {
        Questions question = new Questions();
        Quizzes quiz = quizService.getQuizById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        question.setQuiz(quiz);
        model.addAttribute("question", question);
        model.addAttribute("quizId", quizId);
        return "/questions/form";
    }

    // Save a new question
    @PostMapping("/quiz/{quizId}")
    public String createQuestion(@PathVariable Long quizId, @Valid @ModelAttribute Questions question, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("quizId", quizId);
            return "/questions/form";
        }
        // Gán lại quiz để đảm bảo quizId không bị null
        Quizzes quiz = quizService.getQuizById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        question.setQuiz(quiz);
        questionService.createQuestion(question);
        return "redirect:/questions/quiz/" + quizId;
    }

    // Show form to edit an existing question
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Questions question = questionService.getQuestionById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        model.addAttribute("question", question);
        model.addAttribute("quizId", question.getQuiz().getQuizId());
        return "/questions/form";
    }

    // Update an existing question
    @PostMapping("/update/{id}")
    public String updateQuestion(@PathVariable Long id, @Valid @ModelAttribute Questions question, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("quizId", question.getQuiz().getQuizId());
            return "/questions/form";
        }
        // Gán lại quiz để đảm bảo quizId không bị null
        Long quizId = question.getQuiz().getQuizId();
        Quizzes quiz = quizService.getQuizById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        question.setQuiz(quiz);
        questionService.updateQuestion(id, question);
        return "redirect:/questions/quiz/" + quizId;
    }

    // Delete a question
    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        Questions question = questionService.getQuestionById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        Long quizId = question.getQuiz().getQuizId();
        questionService.deleteQuestion(id);
        return "redirect:/questions/quiz/" + quizId;
    }
}