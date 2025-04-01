package com.example.userapi.model;

public class User {
    private String nick;
    private String name;

    // Constructors
    public User() {}

    public User(String nick, String name) {
        this.nick = nick;
        this.name = name;
    }

    // Getters and Setters
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}