package main.java.dto;

import java.time.LocalDate;

public class MovieDetailDTO {
    private int movie_id;
    private String title;
    private String description;
    private String poster_url;
    private String trailer_url;
    private String genre;
    private int duration;
    private LocalDate release_date;

    public MovieDetailDTO(int movie_id, String title, String description, String poster_url, String trailer_url, String genre, int duration, LocalDate release_date) {
        this.movie_id = movie_id;
        this.title = title;
        this.description = description;
        this.poster_url = poster_url;
        this.trailer_url = trailer_url;
        this.genre = genre;
        this.duration = duration;
        this.release_date = release_date;
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

    public LocalDate getRelease_date() {
        return release_date;
    }
}
