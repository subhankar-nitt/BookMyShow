package org.example.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {

    private  List<Theater> theaters = new ArrayList<>();
    private Movie movie;
    private Date startTime;
//    private Date endTime;

    public Show(Movie movie, Date startTime) {
        this.movie = movie;
        this.startTime = startTime;
//        this.endTime = endTime;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

//    public Date getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(Date endTime) {
//        this.endTime = endTime;
//    }
}