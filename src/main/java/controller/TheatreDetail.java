package main.java.controller;

import main.java.dao.TheatreDAO;
import main.java.dao.impl.ThreatreDAOImpl;
import main.java.dto.MovieDetailDTO;
import main.java.dto.RoomPreviewDTO;
import main.java.dto.TheatreDetailDTO;
import main.java.service.TheatreServices;
import main.java.service.impl.TheatreServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Theatre Detail", value = "/theatre-detail")
public class TheatreDetail extends HttpServlet {
    private TheatreServices theatreServices;

    @Override
    public void init(){
        TheatreDAO theatreDAO = new ThreatreDAOImpl();

        this.theatreServices = new TheatreServicesImpl(theatreDAO);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String idRaw =  request.getParameter("id");

            if (idRaw != null && !idRaw.isEmpty()) {
                int TheaatreId = Integer.parseInt(idRaw);
                TheatreDetailDTO theatre = theatreServices.getTheatresByID(TheaatreId);

                if (theatre != null) {
                    request.setAttribute("theatre", theatre);

                    List<RoomPreviewDTO> rooms = theatreServices.getRooms(TheaatreId);
                    request.setAttribute("rooms", rooms);

                    request.getRequestDispatcher("/views/theatre-detail.jsp").forward(request, response);
                }
                else {response.sendRedirect(request.getContextPath() + "/theatre");}
            }
            else {response.sendRedirect(request.getContextPath() + "/theatre");}
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
