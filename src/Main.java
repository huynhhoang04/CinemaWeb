import util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Main", value = "/home")
public class Main  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test = "";
        try {
            Connection conn = DBConnection.getConnection();
            if (conn != null) {
                test = "ok";
            }
            else  {
                test = "đéo ok";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("test", test);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
