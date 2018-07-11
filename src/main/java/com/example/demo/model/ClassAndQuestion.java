package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClassAndQuestion {
    @Id
    @GeneratedValue
    String id;
    String classid;
    String questionid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    @Override
    public String toString() {
        return "ClassAndQuestion{" +
                "id='" + id + '\'' +
                ", classid='" + classid + '\'' +
                ", questionid='" + questionid + '\'' +
                '}';
    }
}
