package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.dto.QuizSubmissionDTO;
import com.example.elearningwebm4.backend.models.Certificates;
import com.example.elearningwebm4.backend.models.Courses;
import com.example.elearningwebm4.backend.models.Questions;
import com.example.elearningwebm4.backend.models.QuizAttempts;
import com.example.elearningwebm4.backend.models.Quizzes;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.CertificatesRepository;
import com.example.elearningwebm4.backend.repositories.QuizAttemptRepository;
import com.example.elearningwebm4.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private CertificatesRepository certificatesRepository;

    @Autowired
    private CoursesServiceImpl coursesService;

    public QuizAttempts submitQuiz(QuizSubmissionDTO submission, String userEmail) {
        // Tìm người dùng
        Users user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Tìm quiz
        Quizzes quiz = quizService.getQuizById(submission.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // Lấy danh sách câu hỏi của quiz
        List<Questions> questions = questionService.getQuestionsByQuizId(submission.getQuizId());
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions found for this quiz");
        }

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
        quizAttemptRepository.save(attempt);

        // Cấp chứng chỉ nếu điểm > 80 và chưa có chứng chỉ
        if (score > 80) {
            Long courseId = getCourseIdForQuiz(submission.getQuizId());
            Optional<Certificates> existingCertificate = certificatesRepository
                    .findByUserUserIdAndCourseCourseId(user.getUserId(), courseId);
            if (existingCertificate.isEmpty()) {
                Courses course = coursesService.findById(courseId)
                        .orElseThrow(() -> new RuntimeException("Course not found"));

                Certificates certificate = new Certificates();
                certificate.setCertificateUrl(null); // Có thể thêm logic tạo URL
                certificate.setIssueDate(LocalDateTime.now());
                certificate.setUser(user);
                certificate.setCourse(course);

                certificatesRepository.save(certificate);
            }
        }

        return attempt;
    }

    public List<QuizAttempts> getUserAttempts(Long userId, Long quizId) {
        return quizAttemptRepository.findByUserUserIdAndQuizQuizId(userId, quizId);
    }

    private Long getCourseIdForQuiz(Long quizId) {
        // Ánh xạ quiz_id sang course_id
        switch (quizId.intValue()) {
            case 1: return 1L; // Java
            case 2: return 2L; // JavaScript
            case 3: return 3L; // Python
            default: throw new RuntimeException("Invalid quiz ID: " + quizId);
        }
    }
}