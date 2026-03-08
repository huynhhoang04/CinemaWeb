package main.java.dao;

import main.java.model.entity.User;

public interface UserDAO {
    User login(String account, String password);
    boolean register(User user);
    boolean checkUserExists(String username, String email);
    String getHashedPassword(int user_id);
    boolean updatePassword(int user_id, String newPassword);
}
