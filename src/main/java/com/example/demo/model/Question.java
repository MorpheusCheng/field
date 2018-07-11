package com.example.demo.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by hello on 2018/6/21.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue
    private int questionid;
    private String questionkeyword;
    private String question;
    private String own;
    private String ownid;

    @Override
    public String toString() {
        return "Question{" +
                "questionid=" + questionid +
                ", questionkeyword='" + questionkeyword + '\'' +
                ", question='" + question + '\'' +
                ", own='" + own + '\'' +
                '}';
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestionkeyword() {
        return questionkeyword;
    }

    public void setQuestionkeyword(String questionkeyword) {
        this.questionkeyword = questionkeyword;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public String getOwnid() {
        return ownid;
    }

    public void setOwnid(String ownid) {
        this.ownid = ownid;
    }

}
