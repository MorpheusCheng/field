package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hello on 2018/6/22.
 */
public interface MessageSave extends JpaRepository<Message,Integer> {
     List<Message> findByQuestionid(Integer question_id);
}
