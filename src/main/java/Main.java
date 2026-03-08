package main.java;

import main.java.dao.MovieDAO;
import main.java.dao.impl.MovieDAOImpl;
import main.java.dto.MovieThumnailDTO;
import main.java.service.impl.MovieServiesImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieDAOImpl movieDAO = new MovieDAOImpl();
        MovieServiesImpl movieServies = new MovieServiesImpl(movieDAO);

        List<MovieThumnailDTO> dtos = movieServies.getTop7NewestMovies();
        dtos.forEach(movieThumnailDTO -> {
            System.out.println(movieThumnailDTO.getTitle());
        });
    }
}
