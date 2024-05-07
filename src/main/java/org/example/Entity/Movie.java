package org.example.Entity;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private List<Show> shows = new ArrayList<>();
    private String movieName;
    private String directorName;
    private int duration;
    private String language;



    public Movie(String movieName, String directorName, int duration, String language) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.duration = duration;
        this.language = language;
    }

    public List<Show> getShows(){
        return shows;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
