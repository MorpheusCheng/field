package com.example.demo.websecurity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hello on 2018/4/4.
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;//设定角色名称

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
