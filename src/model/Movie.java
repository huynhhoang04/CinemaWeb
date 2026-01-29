package model;

import model.enums.MovieStatus;

public class Movie {
    private int movie_id;
    private String title;
    private String description;
    private String poster_url;
    private String trailer_url;
    private String genre;
    private int duration;
    private String release_date;
    private MovieStatus movie_status;

    public Movie(int movie_id, String title, String description, String poster_url, String trailer_url, String genre, int duration, String release_date, MovieStatus movie_status) {
        this.movie_id = movie_id;
        this.title = title;
        this.description = description;
        this.poster_url = poster_url;
        this.trailer_url = trailer_url;
        this.genre = genre;
        this.duration = duration;
        this.release_date = release_date;
        this.movie_status = movie_status;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getRelease_date() {
        return release_date;
    }

    public MovieStatus getMovie_status() {
        return movie_status;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setMovie_status(MovieStatus movie_status) {
        this.movie_status = movie_status;
    }
}
