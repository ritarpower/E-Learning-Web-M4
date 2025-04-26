package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.Questions;
import com.example.elearningwebm4.backend.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsServiceImpl {
        @Autowired
        private QuestionRepository questionRepository;


        public List<Questions> getAllQuestions() {
            return questionRepository.findAll();
        }


        public Optional<Questions> getQuestionById(Long id) {
            return questionRepository.findById(id);
        }


        public List<Questions> getQuestionsByQuizId(Long quizId) {
            return questionRepository.findByQuizQuizId(quizId);
        }


        public Questions createQuestion(Questions question) {
            return questionRepository.save(question);
        }


        public Questions updateQuestion(Long id, Questions questionDetails) {
            Questions question = questionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            question.setContent(questionDetails.getContent());
            question.setOptionA(questionDetails.getOptionA());
            question.setOptionB(questionDetails.getOptionB());
            question.setOptionC(questionDetails.getOptionC());
            question.setOptionD(questionDetails.getOptionD());
            question.setCorrectAnswer(questionDetails.getCorrectAnswer());
            question.setQuiz(questionDetails.getQuiz());
            return questionRepository.save(question);
        }

        public void deleteQuestion(Long id) {
            Questions question = questionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            questionRepository.delete(question);
        }
    }
