package org.example.Service;

import org.example.Entity.Movie;
import org.example.Entity.Show;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {
    private static Map<String,Movie> movies = new HashMap<>();

    public static void createMovie(String movieName,String directorName,int duration,String language){
        Movie movie= new Movie(movieName,directorName,duration,language);
        movies.put(movieName,movie);
    }

    public static Movie getMovie(String movieName){
        return movies.getOrDefault(movieName,null);
    }

    public static void removeMovies(String movieName){
        if(movies.containsKey(movieName))
            movies.remove(movieName);
    }

    public static  List<Show> getShowByMovieName(String movieName){
        Movie movie = movies.get(movieName);
        return movie.getShows();
    }

    public static List<Show> getShowByMovieNameAndCity(String movieName,String city){
        return ShowService.getShowByCity(city,getShowByMovieName(movieName));
    }
    public static List<Show> getShowByMovieNameAndTheater(String movieName,String theater){
        return ShowService.getShowByTheaterName(theater,getShowByMovieName(movieName));
    }


    public static List<Show> getShowByMovieNameAndTime(String movieName,String showTime) throws ParseException {
        return ShowService.getShowByTime(showTime,getShowByMovieName(movieName));
    }



}
