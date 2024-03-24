package com.woobot.quizservice.controller;

import com.woobot.quizservice.model.QuestionWrapper;
import com.woobot.quizservice.model.QuizDto;
import com.woobot.quizservice.model.Response;
import com.woobot.quizservice.service.QuizService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create") // DTO stands for data transfer object
    public ResponseEntity<List<Integer>> createQuiz(@RequestBody QuizDto quizDto) {
        return ResponseEntity.ok(quizService.createQuiz(quizDto.getCategory(),
                                                        quizDto.getQuestionsNumber(),
                                                        quizDto.getTitle()));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return ResponseEntity.ok(quizService.getQuizQuestions(id));
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
        return ResponseEntity.ok(quizService.calculateResult(id, responses));
    }
}
