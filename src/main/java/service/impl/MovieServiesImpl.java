package main.java.service.impl;

import main.java.dao.MovieDAO;
import main.java.dto.MovieDetailDTO;
import main.java.dto.MovieThumnailDTO;
import main.java.model.entity.Movie;
import main.java.service.MovieServices;

import java.util.ArrayList;
import java.util.List;

public class MovieServiesImpl implements MovieServices {
    private final MovieDAO movieDAO;

    public MovieServiesImpl(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @Override
    public List<MovieThumnailDTO> getTop7NewestMovies() {
        List<Movie> movies = movieDAO.getTop7NewestMovies();
        List<MovieThumnailDTO> dtos = new ArrayList<>();
        movies.forEach(movie -> {
            dtos.add(new MovieThumnailDTO(movie.getMovie_id(), movie.getTitle(), movie.getPoster_url(), movie.getDuration()));
        });
        return dtos;
    }

    @Override
    public MovieDetailDTO getMovieById(int id) {
        Movie movie = movieDAO.getMovieById(id);
        MovieDetailDTO movieDetailDTO = new MovieDetailDTO(movie.getMovie_id(), movie.getTitle(), movie.getDescription(), movie.getPoster_url(), movie.getTrailer_url(), movie.getGenre(), movie.getDuration(), movie.getRelease_date());
        return movieDetailDTO;
    }

    @Override
    public List<MovieThumnailDTO> getMovieByStatusAndPage(String statusRaw, int pageRaw,  String keywordRaw, String tagRaw) {
        int pageSize = 8;
        int offset = (pageRaw - 1) * pageSize;
        String status = statusRaw.toUpperCase();
        String keyword = (keywordRaw == null) ? "" : keywordRaw.trim();
        String tag = (tagRaw == null) ? "" : tagRaw.trim();

        List<Movie> movies = movieDAO.getMovieByStatusAndPage(status, offset, pageSize, keyword, tag);
        List<MovieThumnailDTO> dtos = new ArrayList<>();
        movies.forEach(movie -> {
            dtos.add(new MovieThumnailDTO(movie.getMovie_id(), movie.getTitle(), movie.getPoster_url(), movie.getDuration()));
        });
        return dtos;
    }

    @Override
    public int countMovieByStatus(String statusRaw, String tagRaw,  String keywordRaw) {
        String status = statusRaw.toUpperCase();
        String keyword = (keywordRaw == null) ? "" : keywordRaw.trim();
        String tag = (tagRaw == null) ? "" : tagRaw.trim();
        return movieDAO.countMovieByStatus(status, keyword, tag);
    }
}
