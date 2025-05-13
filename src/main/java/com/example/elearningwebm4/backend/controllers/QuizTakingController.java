package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.dto.QuizSubmissionDTO;
import com.example.elearningwebm4.backend.models.Certificates;
import com.example.elearningwebm4.backend.models.QuizAttempts;
import com.example.elearningwebm4.backend.models.Quizzes;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.CertificatesRepository;
import com.example.elearningwebm4.backend.repositories.UserRepository;
import com.example.elearningwebm4.backend.services.serviceimpl.QuestionsServiceImpl;
import com.example.elearningwebm4.backend.services.serviceimpl.QuizAttemptServiceImpl;
import com.example.elearningwebm4.backend.services.serviceimpl.QuizzesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/take-quiz")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class QuizTakingController {

    @Autowired
    private QuizzesServiceImpl quizService;

    @Autowired
    private QuestionsServiceImpl questionService;

    @Autowired
    private QuizAttemptServiceImpl quizAttemptService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CertificatesRepository certificatesRepository;

    // Hiển thị danh sách quizzes
    @GetMapping
    public String listQuizzes(Model model) {
        model.addAttribute("quizzes", quizService.getAllQuizzes());
        return "take/list";
    }

    // Hiển thị form làm bài kiểm tra
    @GetMapping("/{quizId}")
    public String showQuizForm(@PathVariable Long quizId, Model model) {
        Quizzes quiz = quizService.getQuizById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
        model.addAttribute("quiz", quiz);
        model.addAttribute("questions", questionService.getQuestionsByQuizId(quizId));
        model.addAttribute("submission", new QuizSubmissionDTO());
        return "take/take";
    }

    // Xử lý bài nộp
    @PostMapping("/submit/{quizId}")
    public String submitQuiz(@PathVariable Long quizId, @ModelAttribute QuizSubmissionDTO submission,
                             Authentication authentication, Model model) {
        submission.setQuizId(quizId);
        String userEmail = authentication.getName();
        QuizAttempts attempt = quizAttemptService.submitQuiz(submission, userEmail);

        // Lấy user
        Users user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Kiểm tra xem có chứng chỉ cho khóa học tương ứng không
        Long courseId = getCourseIdForQuiz(quizId); // Ánh xạ quizId sang courseId
        Optional<Certificates> certificate = certificatesRepository
                .findByUserUserIdAndCourseCourseId(user.getUserId(), courseId);

        // Thêm dữ liệu vào model
        model.addAttribute("attempt", attempt);
        model.addAttribute("questions", questionService.getQuestionsByQuizId(quizId));
        model.addAttribute("userAnswers", submission.getAnswers());
        model.addAttribute("hasCertificate", certificate.isPresent() && attempt.getScore() > 80);

        return "take/result";
    }

    // Hiển thị chứng chỉ
    @GetMapping("/certificates")
    public String showCertificates(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Users user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Certificates> certificates = certificatesRepository.findAllByUserUserId(user.getUserId());
        model.addAttribute("certificates", certificates);
        return "certificates/list";
    }

    // Hiển thị lịch sử làm bài
    @GetMapping("/history/{quizId}")
    public String showHistory(@PathVariable Long quizId, Authentication authentication, Model model) {
        String userEmail = authentication.getName();
        Users user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("attempts", quizAttemptService.getUserAttempts(user.getUserId(), quizId));
        model.addAttribute("quizId", quizId);
        return "take/history";
    }

    // Hàm ánh xạ quizId sang courseId
    private Long getCourseIdForQuiz(Long quizId) {
        switch (quizId.intValue()) {
            case 1: return 1L; // Java
            case 2: return 2L; // JavaScript
            case 3: return 3L; // Python
            default: throw new RuntimeException("Invalid quiz ID: " + quizId);
        }
    }
}