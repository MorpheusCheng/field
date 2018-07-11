package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClassAndStutents {
    @Id
    @GeneratedValue
    String id;
    String classid;
    String stutentsid;

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

    public String getStutentsid() {
        return stutentsid;
    }

    public void setStutentsid(String stutentsid) {
        this.stutentsid = stutentsid;
    }

    @Override
    public String toString() {
        return "ClassAndStutents{" +
                "id='" + id + '\'' +
                ", classid='" + classid + '\'' +
                ", stutentsid='" + stutentsid + '\'' +
                '}';
    }
}
