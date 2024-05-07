package org.example.Entity;

import java.util.ArrayList;
import java.util.List;
import org.example.Service.TheaterOwnerService;

public class TheaterOwner extends TheaterOwnerService{

    private List<Theater> theaters=new ArrayList<>();
    private String name;

    public TheaterOwner(String name) {
        this.name = name;
    }

    @Override
    public  void createTheater(String theaterName,String theaterCity){
        String key =theaterName+"_"+theaterCity;
        Theater theater = new Theater(theaterName,theaterCity,this);
        theaters.add(theater);
    }

    @Override
    public void createAuditorium(String theaterName,String theaterCity,int seatCount){
        Theater theater=getTheatersByNameAndCity(theaterName,theaterCity);
        Auditorium auditorium = new Auditorium(seatCount,theater);
        theater.getAuditoriums().add(auditorium);
    }

    @Override
    public List<Theater> getAllTheaters() {
        return theaters;
    }

    @Override
    public List<Theater> getTheatersByName(String theaterName){
        List<Theater> theaterByName = new ArrayList<>();

        theaters.forEach(theater -> {
            if(theater.getTheaterName().equals(theaterName)){
                theaterByName.add(theater);
            }
        });
        return theaterByName;
    }

    @Override
    public List<Theater> getTheatersByCity(String city){
        List<Theater> theaterByName = new ArrayList<>();

        theaters.forEach(theater -> {
            if(theater.getTheaterName().equals(city)){
                theaterByName.add(theater);
            }
        });
        return theaterByName;
    }

    @Override
    public Theater getTheatersByNameAndCity(String name, String City) {
        for(Theater theater:theaters){
            if(theater.getTheaterCity().equals(City) && theater.getTheaterName().equals(name))
                return theater;

        }

        return  null;
    }


}
