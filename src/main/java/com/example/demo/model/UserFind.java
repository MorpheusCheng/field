package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFind extends JpaRepository<User,String> {
    @Query(value = " SELECT user.email,user.name " +
            " FROM user INNER JOIN class_and_stutents on `user`.id = class_and_stutents.stutentsid "+
            " WHERE class_and_stutents.classid = ?1 and user.title = 'student'",nativeQuery = true)
    List<Object[]> findBystudnetnid(String id);
}
