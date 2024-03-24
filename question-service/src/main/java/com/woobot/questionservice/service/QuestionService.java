package com.woobot.questionservice.service;

import com.woobot.questionservice.dao.QuestionDao;
import com.woobot.questionservice.model.Question;
import com.woobot.questionservice.model.QuestionWrapper;
import com.woobot.questionservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public Question createQuestion(Question data) {
        return questionDao.save(data);
    }

    public List<Integer> getQuestionsForQuiz(String category, int questionsNum) {
        return questionDao.findRandomQuestionsByCategory(category, questionsNum);
    }

    public List<QuestionWrapper> getQuestionsById(List<Integer> ids) {
        // at first, we need to get questions by ids from db
        // and narrow its type to questionWrapper
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        List<Question> questionList = new ArrayList<>();

        // getting all questions by id
        for (int qId : ids) {
            questionList.add(questionDao.findById(qId).get());
        }

        // map all questions to questionWrappers
        for (Question question : questionList) {
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getCategory(),
                    question.getTitle(), question.getOption1(), question.getOption2(), question.getOption3(),
                    question.getOption4());

            questionWrappers.add(questionWrapper);
        }


        return questionWrappers;
    }

    public Integer getScore(List<Response> responses) {
        int rightAns = 0;

        for (Response res : responses) {
            Question question = questionDao.findById(res.getId()).get();
            if (res.getResponse().equals(question.getRightAnswer()))
                rightAns++;
        }

        return rightAns;
    }
}
