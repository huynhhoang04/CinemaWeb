package main.java.dao;

import main.java.model.entity.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getTop7NewestMovies();
    Movie getMovieById(int id);
    List<Movie> getMovieByStatusAndPage(String status, int page, int size, String keyword, String tag);
    int countMovieByStatus(String status, String keyword, String tag);
}
