package main.java.model.entity;

import main.java.model.enums.Role;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String full_name;
    private Role roll;
    private String email;

    public User(){
    };

    public User(int user_id, String username, String password, String full_name, Role roll, String email) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.roll = roll;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFull_name() {
        return full_name;
    }

    public Role getRoll() {
        return roll;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setRoll(Role roll) {
        this.roll = roll;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
