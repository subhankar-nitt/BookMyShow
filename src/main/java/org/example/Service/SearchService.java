package org.example.Service;

import org.example.Entity.Show;
import org.example.Entity.Theater;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public static List<String> getAllShowByName(String movieName){
        List<Show> shows=MovieService.getShowByMovieName(movieName);
        return generateStringList(shows);
    }

    public static List<String> getAllShowByTheaterName(String theaterName){
        List<Show> shows = ShowService.getShowByTheaterName(theaterName);
        return generateStringList(shows);
    }

    public static List<Show> getShowByMovieNameTheaterNameCityTime(String movieName,String CityName,String theaterName,String time) throws ParseException {
        List<Show> showsByMovieNameAndTime = MovieService.getShowByMovieNameAndTime(movieName,time);
        List<Show> showsByMovieNameTimeAndCityName = ShowService.getShowByCity(CityName,showsByMovieNameAndTime);
        List<Show> showsByMovieNameTimeCityNameTheaterName = ShowService.getShowByTheaterName(theaterName,showsByMovieNameTimeAndCityName);

        return showsByMovieNameTimeCityNameTheaterName;
    }

    private static List<String> generateStringList(List<Show> shows){
        List<String> list = new ArrayList<>();
        for(Show show: shows){
            for(Theater theater: show.getTheaters()){

                String val = "Movie : "+show.getMovie().getMovieName()+" starting from "+show.getStartTime().toString()+" in cinema "+theater.getTheaterName()+" city "+theater.getTheaterCity();
                list.add(val);
            }


        }
        return list;
    }

}
