package org.example.Service;

import org.example.Entity.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class TheaterOwnerService {


    private HashMap<String,Theater> theaterHashMap = new HashMap<>();
    public abstract void createTheater(String theaterName, String theaterCity);
    public abstract void createAuditorium(String theaterName, String theaterCity, int seatCount);

    public abstract List<Theater> getAllTheaters();

    public abstract List<Theater> getTheatersByName(String theaterName);

    public abstract List<Theater> getTheatersByCity(String city);

    public abstract Theater getTheatersByNameAndCity(String name,String City);



}
