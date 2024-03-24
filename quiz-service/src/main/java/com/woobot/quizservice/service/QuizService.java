package com.woobot.quizservice.service;


import com.woobot.quizservice.dao.QuizDao;
import com.woobot.quizservice.feign.QuizInterface;
import com.woobot.quizservice.model.QuestionWrapper;
import com.woobot.quizservice.model.Quiz;
import com.woobot.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public List<Integer> createQuiz(String category, int questionsNum, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, questionsNum).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return quiz.getQuestionIds();
    }

    public List<QuestionWrapper> getQuizQuestions(int id) {
        Quiz quiz = quizDao.findById(id).get();

        List<Integer> questionIds = quiz.getQuestionIds();

        return quizInterface.getQuestionsById(questionIds).getBody();
    }

    public Integer calculateResult(int id, List<Response> responses) {
        return quizInterface.getScore(responses).getBody();
    }
}
