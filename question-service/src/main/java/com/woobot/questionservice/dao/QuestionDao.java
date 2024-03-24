package com.woobot.questionservice.dao;

import com.woobot.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {// type of table/type of primary key
    List<Question> findByCategory(String category);

    @Query(value = "select q.id from question q where q.category=:category order by random() limit :questionsNum",
            nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int questionsNum);
}
