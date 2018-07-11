package com.example.demo.validation;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hello on 2018/3/24.
 */

public interface UserRepository extends JpaRepository<User,String>{
    public User findByEmail(String email);
}
