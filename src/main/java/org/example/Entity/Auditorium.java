package org.example.Entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Auditorium {


    private  static final AtomicLong count = new AtomicLong(1);
    private Long id;
    private Theater theater;
    private int auditoriumNumber;
    private int seatCount;

    private Booking [] seats;


    public Auditorium( int seatCount,Theater theater) {
        this.id = count.incrementAndGet();
        this.seatCount = seatCount;
        this.theater=theater;
        seats = new Booking[seatCount];
    }


    public Long getId() {
        return id;
    }

    public Booking[] getSeats() {
        return seats;
    }

    public int getFreeSeatCount(){
        int freeSeat = (int)Arrays.stream(seats).filter(Objects::isNull).count();

        return freeSeat;
    }

    public int isSeatOccupied(List<Integer> seatsList){
        for(int seat: seatsList){
            if(seats[seat-1]!=null){
//                System.out.println("Seat No seat is already booked ! please try another one");
                return seat;
            }

        }
        return -1;
    }
    public  synchronized boolean lockSeat(List<Integer> seatList,Booking booking){
        int seatNo = isSeatOccupied(seatList);

        if(seatNo!=-1){
            System.out.println("Seat "+seatNo+" is already booked please Choose some other seat");
//            System.out.println(seatList);
            return  false;
        }
        for(int seat: seatList){
            seats[seat-1]=booking;
        }
        return true;
    }

    public void unLockSeat(List<Integer>seatList){
        for(int seat: seatList){
            seats[seat-1]=null;
        }
    }


    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public int getAuditoriumNumber() {
        return auditoriumNumber;
    }

    public void setAuditoriumNumber(int auditoriumNumber) {
        this.auditoriumNumber = auditoriumNumber;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
