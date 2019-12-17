package com.scu.adminWeb.common.domain;

public class User {
    private int id;
    private String name;
    private String passWord;


    public User() {
    }

    public User(int id, String name, String passWord) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public User setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }
}
