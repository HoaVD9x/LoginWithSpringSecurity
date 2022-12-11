package com.example.loginwithspringsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String userName;

    private String email;

    private String password;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    public User() {
    }

    public User(String userName, String email, String password, boolean accountNonLocked) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.accountNonLocked = accountNonLocked;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
}
