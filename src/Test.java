import util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
