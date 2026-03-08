package main.java.controller;

import main.java.dao.ArticleDAO;
import main.java.dao.MovieDAO;
import main.java.dao.impl.ArticleDAOImpl;
import main.java.dao.impl.MovieDAOImpl;
import main.java.dto.ArticleThumnailDTO;
import main.java.dto.MovieThumnailDTO;
import main.java.model.entity.Movie;
import main.java.service.ArticleSevrvices;
import main.java.service.MovieServices;
import main.java.service.impl.ArticleServicesImpl;
import main.java.service.impl.MovieServiesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    private MovieServices movieServices;
    private ArticleSevrvices articleServices;

    @Override
    public void init() throws ServletException {
        MovieDAO movieDAO = new MovieDAOImpl();
        ArticleDAO articleDAO = new ArticleDAOImpl();

        this.movieServices = new MovieServiesImpl(movieDAO);
        this.articleServices = new ArticleServicesImpl(articleDAO);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<MovieThumnailDTO> movieDtos = movieServices.getTop7NewestMovies();
        List<ArticleThumnailDTO> articlesDtos = articleServices.getTop3Articles();
        request.setAttribute("topMovies", movieDtos);
        request.setAttribute("topArticles", articlesDtos);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
