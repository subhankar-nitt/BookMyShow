package org.example.Service;

import org.example.Entity.*;
import org.example.constatns.PaymentsEnum;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private static List<Booking> bookings = new ArrayList<>();
    public static  void createBooking(String theaterName, String cityName, String startTime, String movieName, List<Integer> seats, TheaterOwnerService theaterOwner) throws ParseException {
        List<Show> shows = SearchService.getShowByMovieNameTheaterNameCityTime(movieName,cityName,theaterName,startTime);
        assert shows.size()!=0;

        Theater theater = ShowService.getTheaterForShow(theaterName,cityName,startTime,movieName);
        assert theater!=null;
        String audiString = String.valueOf(AuditoriumService.getMostlyOccupiedAuditorium(theater).getId());
        Booking booking = new Booking(seats,shows.get(0),theater,audiString, PaymentsEnum.INITIATED);
        Auditorium auditorium = AuditoriumService.reserveSeat(theater,seats,booking);

        System.out.println(seats);
        if(auditorium==null){
            System.out.println("Booking can not be completed for ");
            return;
        }

        PaymentsEnum status = PaymtStatusGen.generateBookingStatus(booking);
        if(status.equals(PaymentsEnum.COMPLETED)) {
            System.out.println("Booking successfull!");
            bookings.add(booking);
        }else if(status.equals(PaymentsEnum.FAILED)){
            System.out.println("Payments Failed!");
            AuditoriumService.unLockSeats(theater,seats,auditorium);
        }
    }
}
