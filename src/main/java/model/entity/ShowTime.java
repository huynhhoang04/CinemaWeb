package main.java.model.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShowTime {
    private int showtime_id;
    private int movie_id;
    private int room_id;
    private LocalDateTime start_at;
    private BigDecimal price;

    public ShowTime(int showtime_id, int movie_id, int room_id, LocalDateTime start_at, BigDecimal price) {
        this.showtime_id = showtime_id;
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.start_at = start_at;
        this.price = price;
    }

    public int getShowtime_id() {
        return showtime_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public LocalDateTime getStart_at() {
        return start_at;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setShowtime_id(int showtime_id) {
        this.showtime_id = showtime_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setStart_at(LocalDateTime start_at) {
        this.start_at = start_at;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
