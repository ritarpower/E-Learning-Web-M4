package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.Quizzes;
import com.example.elearningwebm4.backend.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzesServiceImpl {

    @Autowired
    private QuizRepository quizRepository;

    // Lấy tất cả bài kiểm tra
    public List<Quizzes> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Lấy bài kiểm tra theo ID
    public Optional<Quizzes> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    // Tạo bài kiểm tra mới
    public Quizzes createQuiz(Quizzes quiz) {
        return quizRepository.save(quiz);
    }

    // Cập nhật bài kiểm tra
    public Quizzes updateQuiz(Long id, Quizzes quizDetails) {
        Quizzes quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setTitle(quizDetails.getTitle());
        quiz.setTotalMarks(quizDetails.getTotalMarks());
        quiz.setLesson(quizDetails.getLesson());
        return quizRepository.save(quiz);
    }

    // Xóa bài kiểm tra
    public void deleteQuiz(Long id) {
        Quizzes quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        quizRepository.delete(quiz);
    }
}
