package main.java.service;

import main.java.dto.MovieDetailDTO;
import main.java.dto.MovieThumnailDTO;
import main.java.model.entity.Movie;

import java.util.List;

public interface MovieServices {
    List<MovieThumnailDTO> getTop7NewestMovies();
    MovieDetailDTO getMovieById(int id);
    List<MovieThumnailDTO> getMovieByStatusAndPage(String statusRaw, int pageRaw, String keywordRaw, String tagRaw);
    int countMovieByStatus(String statusRaw, String keywordRaw, String tagRaw);
}
