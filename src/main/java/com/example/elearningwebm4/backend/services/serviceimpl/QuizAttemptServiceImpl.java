package com.example.elearningwebm4.backend.services.serviceimpl;
import com.example.elearningwebm4.backend.dto.QuizSubmissionDTO;
import com.example.elearningwebm4.backend.models.Questions;
import com.example.elearningwebm4.backend.models.QuizAttempts;
import com.example.elearningwebm4.backend.models.Quizzes;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.QuizAttemptRepository;
import com.example.elearningwebm4.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizAttemptServiceImpl {

    @Autowired
    private QuizAttemptRepository quizAttemptRepository;

    @Autowired
    private QuestionsServiceImpl questionService;

    @Autowired
    private QuizzesServiceImpl quizService;

    @Autowired
    private UserRepository userRepository;

    public QuizAttempts submitQuiz(QuizSubmissionDTO submission, String userEmail) {
        // Tìm người dùng
        Users user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Tìm quiz
        Quizzes quiz = quizService.getQuizById(submission.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Lấy danh sách câu hỏi của quiz
        List<Questions> questions = questionService.getQuestionsByQuizId(submission.getQuizId());

        // Tính điểm
        double totalMarks = quiz.getTotalMarks();
        double markPerQuestion = totalMarks / questions.size();
        int correctAnswers = 0;

        for (Questions question : questions) {
            String userAnswer = submission.getAnswers().get(question.getQuestionId());
            if (userAnswer != null && userAnswer.equals(question.getCorrectAnswer())) {
                correctAnswers++;
            }
        }

        double score = correctAnswers * markPerQuestion;

        // Lưu kết quả bài làm
        QuizAttempts attempt = new QuizAttempts();
        attempt.setUser(user);
        attempt.setQuiz(quiz);
        attempt.setScore(score);
        attempt.setAttemptDate(LocalDateTime.now());

        return quizAttemptRepository.save(attempt);
    }

    public List<QuizAttempts> getUserAttempts(Long userId, Long quizId) {
        return quizAttemptRepository.findByUserUserIdAndQuizQuizId(userId, quizId);
    }
}