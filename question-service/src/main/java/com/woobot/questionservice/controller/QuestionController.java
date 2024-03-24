package com.woobot.questionservice.controller;

import com.woobot.questionservice.model.Question;
import com.woobot.questionservice.model.QuestionWrapper;
import com.woobot.questionservice.model.Response;
import com.woobot.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

//    @Autowired
//    Environment environment; // to test if loadBalancer from feign works

    @GetMapping("all-questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(questionService.getQuestionsByCategory(category));
    }

    @PostMapping("create")
    public ResponseEntity<Question> createQuestion(@RequestBody Question data) {
        return ResponseEntity.ok(questionService.createQuestion(data));
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,
                                                             @RequestParam int questionsNum) {
//        System.out.println(environment.getProperty("local.server.port")); // test if loadBalancer from feign works
        return ResponseEntity.ok(questionService.getQuestionsForQuiz(category, questionsNum));
    }

    @PostMapping("get-questions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> ids) {
        return ResponseEntity.ok(questionService.getQuestionsById(ids));
    }

    @GetMapping("get-score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return ResponseEntity.ok(questionService.getScore(responses));
    }
}
