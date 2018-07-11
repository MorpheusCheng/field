package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClassAndQuestionSave extends JpaRepository<ClassAndQuestion,String> {
    List<ClassAndQuestion> findByClassidEquals(String class_id);
    @Transactional
    @Modifying
    @Query(value = "DELETE question,class_and_question FROM question INNER JOIN class_and_question on  " +
            "question.questionid=class_and_question.question_id WHERE question.questionid=?1",nativeQuery = true)
    public List<Object[]> deleteByQuestionId(String questionid);

}
