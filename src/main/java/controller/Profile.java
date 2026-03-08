package main.java.controller;

import main.java.dao.UserDAO;
import main.java.dao.impl.UserDAOImpl;
import main.java.model.entity.User;
import main.java.service.UserServices;
import main.java.service.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Profile", value = "/profile")
public class Profile extends HttpServlet {
    private UserServices userServices;

    @Override
    public void init() {
        UserDAO userDAO = new UserDAOImpl();

        this.userServices = new UserServicesImpl(userDAO);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            User currentUser = (User) session.getAttribute("currentUser");
            session.setAttribute("currentUser", currentUser);
            request.getRequestDispatcher("/views/user/profile.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            User currentUser = (User) session.getAttribute("currentUser");

            if(currentUser == null){response.sendRedirect(request.getContextPath() + "/auth?action=login"); return;}

            if(request.getParameter("action").equals("change_password")){
                String oldPassword = request.getParameter("oldPassword");
                String newPassword = request.getParameter("newPassword");
                String confirmNewPassword = request.getParameter("confirmPassword");

                String result = userServices.updatePassword(currentUser, oldPassword, newPassword, confirmNewPassword);
                if(result.equals("SUCCESS")){
                    request.setAttribute("message", "Đổi mật khẩu thành công!");
                }
                else{
                    request.setAttribute("error", result);
                }
                request.getRequestDispatcher("/views/user/profile.jsp").forward(request, response);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
