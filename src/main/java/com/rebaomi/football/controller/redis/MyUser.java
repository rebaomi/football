package com.rebaomi.football.controller.redis;

import java.io.Serializable;

public class MyUser implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3439357743481693800L;

    private String username;
    
    private int age;

    public MyUser() {
        super();
    }

    public MyUser(String username, int age) {
        super();
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
