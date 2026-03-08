package main.java.dao.impl;

import main.java.dao.UserDAO;
import main.java.mapper.UserMaapper;
import main.java.model.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import main.java.util.DBConnection;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public User login(String account, String password) {
        String sql = "select * from get_user_for_login(?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (BCrypt.checkpw(password, dbPassword)) {
                    return UserMaapper.map(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        System.out.print(user.getUsername() + " " + user.getPassword() + " " + user.getEmail() + " " + user.getFull_name());
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        String sql = "call register_user(?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             CallableStatement ps = con.prepareCall(sql);){
            ps.setString(1, user.getUsername());
            ps.setString(2, hashedPassword);
            ps.setString(3, user.getFull_name());
            ps.setString(4, user.getEmail());

            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public boolean checkUserExists(String username, String email) {
        String sql = "select * from check_user_exists(?, ?)";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, username);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public String getHashedPassword(int user_id) {
        String sql = "select * from get_password_by_id(?);";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean updatePassword(int user_id, String newPassword) {
        String sql = "call update_password(?, ?)";
        try (Connection con = DBConnection.getConnection();
        CallableStatement ps = con.prepareCall(sql);) {
            ps.setString(1, newPassword);
            ps.setInt(2, user_id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
