package org.example.Entity;

import org.example.constatns.PaymentsEnum;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private List<Integer> seats = new ArrayList<>();
    private Show show;
    private Theater theater;

    private String auditorium;
    private PaymentsEnum paymtStatus;


    public Booking(List<Integer> seats, Show show, Theater theater, String auditorium, PaymentsEnum paymtStatus) {
        this.seats = seats;
        this.show = show;
        this.theater = theater;
        this.auditorium = auditorium;
        this.paymtStatus = paymtStatus;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public PaymentsEnum getPaymtStatus() {
        return paymtStatus;
    }

    public void setPaymtStatus(PaymentsEnum paymtStatus) {
        this.paymtStatus = paymtStatus;
    }
}
