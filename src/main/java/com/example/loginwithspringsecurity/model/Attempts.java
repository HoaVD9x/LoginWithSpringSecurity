package com.example.loginwithspringsecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "attempts")
public class Attempts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private int attempts;

    public Attempts() {
    }

    public Attempts(String userName, int attempts) {
        this.userName = userName;
        this.attempts = attempts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}
