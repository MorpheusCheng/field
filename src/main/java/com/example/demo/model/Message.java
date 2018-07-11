package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Created by hello on 2018/6/22.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue
    private int messageid;
    private int questionid;
    private String message;
    private String time;
    private String own;

    @Override
    public String toString() {
        return "Message{" +
                "messageid=" + messageid +
                ", questionid=" + questionid +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                ", own='" + own + '\'' +
                '}';
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }
}
