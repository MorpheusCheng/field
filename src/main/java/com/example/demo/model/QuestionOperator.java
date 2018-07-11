package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hello on 2018/6/21.
 */
public interface QuestionOperator extends JpaRepository<Question, String> {
    List<Question> findByOwnid(String ownid);
    @Query(value = " SELECT question.* "+
            " FROM question INNER JOIN class_and_question on question.questionid = class_and_question.questionid "+
            " WHERE class_and_question.classid = ?1 ",nativeQuery = true)
    List<Object[]> findByclassid(String classid);
}
