package org.example.Service;

import org.example.Entity.Auditorium;
import org.example.Entity.Booking;
import org.example.Entity.Theater;
import org.example.Entity.TheaterOwner;

import java.util.List;

public class AuditoriumService {

    public static Auditorium getMostlyOccupiedAuditorium(Theater theater){
//        Theater theater = theaterOwner.getTheatersByNameAndCity(name,city);
        List<Auditorium> auditoriumList = theater.getAuditoriums();
        int lowestSeat = Integer.MAX_VALUE;
        Auditorium lowestAudi=null;

        for(Auditorium auditorium : auditoriumList){
            if(lowestSeat>auditorium.getFreeSeatCount()){
                lowestSeat=auditorium.getFreeSeatCount();
            }
            lowestAudi= auditorium;
        }

        return lowestAudi;
    }
    public static Auditorium reserveSeat(Theater theater, List<Integer> seatNumbers, Booking booking){
//        Theater theater = theaterOwner.getTheatersByNameAndCity(name,city);
        Auditorium auditorium = getMostlyOccupiedAuditorium(theater);
        boolean isLcoked = auditorium.lockSeat(seatNumbers,booking);
        if (isLcoked)
            return auditorium;

        return null;

    }

    public static void unLockSeats(Theater theater,List<Integer>seats,Auditorium auditorium){
        auditorium.unLockSeat(seats);
    }


}
