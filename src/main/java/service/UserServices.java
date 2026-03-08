package main.java.service;

import main.java.model.entity.User;

public interface UserServices {
    User login(String account, String rawPassword);
    String register(User newUser, String confirmPassword);
    String updatePassword(User currentUser, String oldPassword, String newPassword, String confirmNewPassword);
}
