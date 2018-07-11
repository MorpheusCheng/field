package com.example.demo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassAndStudentsSave extends JpaRepository<ClassAndStutents,String> {
    @Query(value = " SELECT class_info.*  "+
            " FROM class_info INNER JOIN class_and_stutents on class_info.id = class_and_stutents.classid "+
            " WHERE class_and_stutents.stutentsid = ?1 " ,nativeQuery = true)
    List<Object[]> findByStutentsid(String studentsid);
}
