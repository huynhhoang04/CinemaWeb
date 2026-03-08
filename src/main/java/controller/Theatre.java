package main.java.controller;

import main.java.dao.TheatreDAO;
import main.java.dao.impl.ThreatreDAOImpl;
import main.java.dto.TheatreThumnailDTO;
import main.java.service.TheatreServices;
import main.java.service.impl.TheatreServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Theatre" , value = "/theatre")
public class Theatre extends HttpServlet {
    private TheatreServices theatreServices;

    @Override
    public void init(){
        TheatreDAO theatreDAO = new ThreatreDAOImpl();

        this.theatreServices = new TheatreServicesImpl(theatreDAO);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            List<String> cities = theatreServices.getAvailableCity();
            request.setAttribute("cities", cities);

            try {
                String cityRaw = request.getParameter("city");
                if(cityRaw != null && !cityRaw.isEmpty()){
                    String selectedCity = cityRaw.trim();
                    request.setAttribute("selectedCity", selectedCity);
                    List<TheatreThumnailDTO> theatres = theatreServices.getTheatresByCity(selectedCity);
                    request.setAttribute("theatres", theatres);
                }
            }
            catch (Exception e){
            }

            request.getRequestDispatcher("/views/theatre.jsp").forward(request, response);
        }
        catch (Exception e){
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
