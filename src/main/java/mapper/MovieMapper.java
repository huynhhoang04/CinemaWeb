package main.java.mapper;

import main.java.model.entity.Movie;
import main.java.model.enums.MovieStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MovieMapper {
    public static Movie map(ResultSet rs) throws SQLException {
        int movie_id = rs.getInt("movie_id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        String poster_url = rs.getString("poster_url");
        String trailer_url = rs.getString("trailer_url");
        String genre = rs.getString("genre");
        int duration = rs.getInt("duration");
        LocalDate release_date = rs.getDate("release_date").toLocalDate();
        String movie_status = rs.getString("movie_status");
        MovieStatus movieStatus = MovieStatus.valueOf(movie_status);
        return new Movie(movie_id, title, description, poster_url, trailer_url, genre, duration, release_date, movieStatus);
    }
}
