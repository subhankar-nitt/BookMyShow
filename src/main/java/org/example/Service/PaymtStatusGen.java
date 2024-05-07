package org.example.Service;

import org.example.Entity.Booking;
import org.example.constatns.PaymentsEnum;

import java.util.ArrayList;
import java.util.List;

public class PaymtStatusGen {

    private static List<Booking> bookings = new ArrayList<>();

    private static boolean isfailing = false;
    public static PaymentsEnum generateBookingStatus(Booking booking){

//        boolean isfailing = false;

        if(isfailing==true){
            isfailing=false;
            return PaymentsEnum.FAILED;
        }
        if(bookings.size()!=0 && bookings.size()%2==0){
            isfailing=true;

        }
        bookings.add(booking);
        return PaymentsEnum.COMPLETED;
    }
}
