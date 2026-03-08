package main.java.mapper;

import main.java.model.entity.User;
import main.java.model.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMaapper {
    public static User map(ResultSet rs) throws SQLException {
        int user_id =  rs.getInt("user_id");
        String username =  rs.getString("username");
        String password =  rs.getString("password");
        String full_name =   rs.getString("full_name");
        String email  =  rs.getString("email");
        Role roll = Role.valueOf(rs.getString("role"));

        return new User(user_id, username, password, full_name, roll, email);
    }
}
