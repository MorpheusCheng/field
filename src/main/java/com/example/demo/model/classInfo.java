package com.example.demo.model;

import javax.lang.model.element.NestingKind;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hello on 2018/7/4.
 */
@Entity
public class classInfo {
    @Id
    @GeneratedValue
    Integer id;
    String className;
    String classId;
    String teacherId;

    public classInfo(){}
    public classInfo(Integer id,String className,String classId,String teacherId){
        this.id = id;
        this.className = className;
        this.classId = classId;
        this.teacherId = teacherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
