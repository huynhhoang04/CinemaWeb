package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try (InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("dbconfig.properties")) {
            Class.forName("org.postgresql.Driver");
            Properties prop = new Properties();
            prop.load(is);
            String url = prop.getProperty("url");
            String username = prop.getProperty("user");
            String password = prop.getProperty("password");
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
