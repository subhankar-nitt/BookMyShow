package org.example.Service;

import org.example.Entity.Movie;
import org.example.Entity.Show;
import org.example.Entity.Theater;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShowService {

    private static List<Show> showList=new ArrayList<>();

    public static void createShow(String movieName,String startTime,List<List<String>> cityNameList,TheaterOwnerService theaterOwnerService) throws ParseException {
        Movie movie = MovieService.getMovie(movieName);
        assert  movie!=null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

        Date startDate = simpleDateFormat.parse(startTime);
//        Date endDate = simpleDateFormat.parse(endTime);
        Show show = new Show(movie,startDate);

        cityNameList.forEach(mp->{
            show.getTheaters().add(theaterOwnerService.getTheatersByNameAndCity(mp.get(1),mp.get(0)));
        });
        movie.getShows().add(show);
        showList.add(show);

    }

    public static List<Show> getShowList(){
        return showList;
    }
    public static List<Show> getShowByTime(String dateTime,List<Show> ... showLists) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        Date date = simpleDateFormat.parse(dateTime);
        List<Show> opList=showLists.length>0?showLists[0]:showList;
        opList.sort((a, b) -> {
            long dateDiffA = Math.abs(a.getStartTime().getTime() - date.getTime());
            long dateDiffB = Math.abs(b.getStartTime().getTime() - date.getTime());

            return (int)(dateDiffB - dateDiffA);
        });

        return opList;
    }

    public static List<Show> getShowByCity(String city,List<Show> ... showLists){
        List<Show> listShows = new ArrayList<>();
        List<Show> opList=showLists.length>0?showLists[0]:showList;
        opList.forEach(show -> {
            List<Theater> theaters = show.getTheaters();
            for(Theater theater:theaters){
                if(theater.getTheaterCity().equals(city)){
                    listShows.add(show);
                    break;
                }
            }
        });

        return listShows;
    }

    public static List<Show> getShowByTheaterName(String theaterName,List<Show> ... showLists){
        List<Show> listShows = new ArrayList<>();
        List<Show> opList=showLists.length>0?showLists[0]:showList;
        opList.forEach(show -> {
            List<Theater> theaters = show.getTheaters();
            for(Theater theater:theaters){
                if(theater.getTheaterName().equals(theaterName)){
                    listShows.add(show);
                    break;
                }
            }
        });

        return listShows;
    }

    public static Theater getTheaterForShow(String TheaterName,String TheaterCity,String ShowTime,String MovieName) throws ParseException {
        List<Show> showsByMovieName = getShowByTime(ShowTime,MovieService.getShowByMovieName(MovieName));
        for (Show show: showsByMovieName){
            for(Theater theater: show.getTheaters()){
                if (theater.getTheaterName().equals(TheaterName) && theater.getTheaterCity().equals(TheaterCity)){
                    return  theater;
                }
            }
        }
        return null;
    }


}
