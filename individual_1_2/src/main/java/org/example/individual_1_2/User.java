package org.example.individual_1_2;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    // Конструктор, геттер і сеттер
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
