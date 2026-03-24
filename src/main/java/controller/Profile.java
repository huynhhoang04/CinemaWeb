package main.java.controller;

import main.java.dao.BookingDAO;
import main.java.dao.UserDAO;
import main.java.dao.impl.BookingDAOImpl;
import main.java.dao.impl.UserDAOImpl;
import main.java.dto.BookingHistoryDTO;
import main.java.model.entity.User;
import main.java.service.BookingServices;
import main.java.service.UserServices;
import main.java.service.impl.BookingServicesImpl;
import main.java.service.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Profile", value = "/profile")
public class Profile extends HttpServlet {
    private UserServices userServices;
    private BookingServices bookingServices;

    @Override
    public void init() {
        UserDAO userDAO = new UserDAOImpl();
        BookingDAO bookingDAO = new BookingDAOImpl();

        this.userServices = new UserServicesImpl(userDAO);
        this.bookingServices = new BookingServicesImpl(bookingDAO);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            User currentUser = (User) session.getAttribute("currentUser");
            session.setAttribute("currentUser", currentUser);
            List<BookingHistoryDTO> historyList = userServices.getBookingHistory(currentUser.getUser_id());
            request.setAttribute("historyList", historyList);
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

            if(request.getParameter("action").equals("pay_now")){
                int bookingId = Integer.parseInt(request.getParameter("booking_id"));
                session.setAttribute("pending_booking_id", bookingId);
                response.sendRedirect(request.getContextPath() + "/pay");
            }

            if(request.getParameter("action").equals("cancel_booking")){
                int bookingId = Integer.parseInt(request.getParameter("booking_id"));
                boolean isSuccess = bookingServices.updateBookingStatus(bookingId, currentUser.getUser_id(), "CANCEL");

                if (isSuccess) {
                    session.setAttribute("message", "Đã hủy vé thành công!");
                } else {
                    session.setAttribute("error", "Hủy vé thất bại, vui lòng thử lại.");
                }
                response.sendRedirect(request.getContextPath() + "/profile?");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
