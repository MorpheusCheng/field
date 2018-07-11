package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hello on 2018/7/4.
 */
public interface saveClassInfo extends JpaRepository<classInfo,String> {
    List<classInfo> findByTeacherId(String teacherid);
}
