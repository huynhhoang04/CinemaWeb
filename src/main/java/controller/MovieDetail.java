package main.java.controller;

import main.java.dao.MovieDAO;
import main.java.dao.impl.MovieDAOImpl;
import main.java.dto.MovieDetailDTO;
import main.java.service.MovieServices;
import main.java.service.impl.MovieServiesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Movie Detail", value = "/movie-detail")
public class MovieDetail extends HttpServlet {
    private MovieServices movieServices;

    @Override
    public void init() throws ServletException {
        MovieDAO movieDAO = new MovieDAOImpl();

        this.movieServices = new MovieServiesImpl(movieDAO);
    }

    @Override
    public void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
        try {
            String idRaw = request.getParameter("id");

            if (idRaw != null && !idRaw.isEmpty()) {
                int movieId = Integer.parseInt(idRaw);
                MovieDetailDTO movie = movieServices.getMovieById(movieId);

                if (movie != null) {
                    request.setAttribute("movie", movie);
                    request.getRequestDispatcher("/views/movie-detail.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
