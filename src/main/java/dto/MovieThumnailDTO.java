package main.java.dto;

public class MovieThumnailDTO {
    private int movie_id;
    private String title;
    private String poster_url;
    private int duration;

    public MovieThumnailDTO(int movie_id, String title, String poster_url, int duration) {
        this.movie_id = movie_id;
        this.title = title;
        this.poster_url = poster_url;
        this.duration = duration;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public int getDuration() {
        return duration;
    }
}
