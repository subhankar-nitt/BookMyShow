package org.example.Entity;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private List<Auditorium> auditoriums=new ArrayList<>();
    private String theaterName;
    private String theaterCity;

    private TheaterOwner theaterOwner;


    public Theater(String theaterName, String theaterCity, TheaterOwner theaterOwner) {
        this.theaterName = theaterName;
        this.theaterCity = theaterCity;
        this.theaterOwner = theaterOwner;
    }

    public List<Auditorium> getAuditoriums(){
        return auditoriums;
    }
    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterCity() {
        return theaterCity;
    }

    public void setTheaterCity(String theaterCity) {
        this.theaterCity = theaterCity;
    }

    public TheaterOwner getTheaterOwner() {
        return theaterOwner;
    }

    public void setTheaterOwner(TheaterOwner theaterOwner) {
        this.theaterOwner = theaterOwner;
    }
}
