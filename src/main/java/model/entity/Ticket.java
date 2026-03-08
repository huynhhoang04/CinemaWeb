package main.java.model.entity;

public class Ticket {
    private int ticket_id;
    private int booking_id;
    private int showtime_id;
    private String seat_number;

    public Ticket(int ticket_id, int booking_id, int showtime_id, String seat_number) {
        this.ticket_id = ticket_id;
        this.booking_id = booking_id;
        this.showtime_id = showtime_id;
        this.seat_number = seat_number;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getShowtime_id() {
        return showtime_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public void setShowtime_id(int showtime_id) {
        this.showtime_id = showtime_id;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }
}
