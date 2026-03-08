package main.java.model.entity;

import main.java.model.enums.PaymentMethod;
import main.java.model.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Booking {
    private int booking_id;
    private int user_id;
    private LocalDateTime booking_date;
    private BigDecimal total_payment;
    private PaymentStatus payment_status;
    private PaymentMethod payment_method;

    public Booking(int booking_id, int user_id, LocalDateTime booking_date, BigDecimal total_payment, PaymentStatus payment_status, PaymentMethod payment_method) {
        this.booking_id = booking_id;
        this.user_id = user_id;
        this.booking_date = booking_date;
        this.total_payment = total_payment;
        this.payment_status = payment_status;
        this.payment_method = payment_method;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    public BigDecimal getTotal_payment() {
        return total_payment;
    }

    public PaymentStatus getPayment_status() {
        return payment_status;
    }

    public PaymentMethod getPayment_method() {
        return payment_method;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBooking_date(LocalDateTime booking_date) {
        this.booking_date = booking_date;
    }

    public void setTotal_payment(BigDecimal total_payment) {
        this.total_payment = total_payment;
    }

    public void setPayment_status(PaymentStatus payment_status) {
        this.payment_status = payment_status;
    }

    public void setPayment_method(PaymentMethod payment_method) {
        this.payment_method = payment_method;
    }
}
