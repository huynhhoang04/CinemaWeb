package main.java.service.impl;

import main.java.dao.UserDAO;
import main.java.model.entity.User;
import main.java.model.enums.Role;
import org.mindrot.jbcrypt.BCrypt;
import main.java.service.UserServices;

public class UserServicesImpl implements UserServices {
    private UserDAO userDAO;

    public UserServicesImpl(UserDAO userDAO) {this.userDAO=userDAO;}


    @Override
    public User login(String account, String rawPassword) {
        return userDAO.login(account, rawPassword);
    }

    @Override
    public String register(User newUser, String confirmPassword) {
        if (!newUser.getPassword().equals(confirmPassword)) {
            return "Mật khẩu xác nhận không khớp!";
        }

        if (userDAO.checkUserExists(newUser.getUsername(), newUser.getEmail())) {
            return "Tên đăng nhập hoặc Email này đã được sử dụng!";
        }

        boolean isSuccess = userDAO.register(newUser);

        if (isSuccess) {
            return "SUCCESS";
        } else {
            return "Hệ thống đang bận, vui lòng thử lại sau!";
        }
    }

    @Override
    public String updatePassword(User currentUser, String oldPassword, String newPassword, String confirmNewPassword) {
        if(currentUser.getRoll().equals(Role.ADMIN)) {return "Không thể thực hiện thao tác này";}
        try {
            String oldHashPassword = userDAO.getHashedPassword(currentUser.getUser_id());
            if (!BCrypt.checkpw(oldPassword, oldHashPassword)) {
                return "Mật khẩu cũ không khớp!";
            }

            if (!newPassword.equals(confirmNewPassword)) {
                return "Mật khẩu xác nhận không khớp!";
            }
            String newHashPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt(12));
            boolean update = userDAO.updatePassword(currentUser.getUser_id(), newHashPassword);
            return update? "SUCCESS" : "Hệ thống đang bận, vui lòng thử lại!";
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
