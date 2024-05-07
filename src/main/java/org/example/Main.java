package org.example;

import org.example.Entity.TheaterOwner;
import org.example.Service.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParseException {

        TheaterOwnerService theaterOwnerService = new TheaterOwner("Subhankar");

        theaterOwnerService.createTheater("Inox","Kolkata");
        theaterOwnerService.createAuditorium("Inox","Kolkata",200);

        theaterOwnerService.createTheater("Inox","Hydrabad");
        theaterOwnerService.createAuditorium("Inox","Hydrabad",300);

        theaterOwnerService.createTheater("Inox","Chennai");
        theaterOwnerService.createAuditorium("Inox","Chennai",150);

        theaterOwnerService.createTheater("Inox","Bengaluru");
        theaterOwnerService.createAuditorium("Inox","Bengaluru",300);

        theaterOwnerService.createTheater("Inox","Gurgaon");
        theaterOwnerService.createAuditorium("Inox","Gurgaon",200);

        theaterOwnerService.createTheater("Pvr","Kolkata");
        theaterOwnerService.createAuditorium("Pvr","Kolkata",80);

        theaterOwnerService.createTheater("Multiplex","Kolkata");
        theaterOwnerService.createAuditorium("Multiplex","Kolkata",120);

        theaterOwnerService.createTheater("Multiplex","Mumbai");
        theaterOwnerService.createAuditorium("Multiplex","Mumbai",90);

        theaterOwnerService.createTheater("Multiplex","Gurgaon");
        theaterOwnerService.createAuditorium("Multiplex","Gurgaon",230);

        theaterOwnerService.createTheater("Pvr","Mumbai");
        theaterOwnerService.createAuditorium("Pvr","Mumbai",80);

        theaterOwnerService.createTheater("Pvr","Chennai");
        theaterOwnerService.createAuditorium("Pvr","Chennai",57);

        theaterOwnerService.createTheater("Multiplex","Hydrabad");
        theaterOwnerService.createAuditorium("Multiplex","Hydrabad",78);

        theaterOwnerService.createTheater("Multiplex","Bengalore");
        theaterOwnerService.createAuditorium("Multiplex","Bengalore",98);
//        theaterOwnerService.createTheater("Inox","Kolkata");
//        theaterOwnerService.createTheater("Inox","Kolkata");
//        theaterOwnerService.createTheater("Inox","Kolkata");


        MovieService.createMovie("Goldfinger","Guy Hamilton",110,"english");
        MovieService.createMovie("Thunderball","Terence Young",130,"Chinise");
        MovieService.createMovie("The Good, the Bad and the Ugly","Sergio Leone",161,"mexican");
        MovieService.createMovie("You Only Live Twice","Lewis Gilbert",117,"english");
        MovieService.createMovie("Diamonds Are Forever","Guy Hamilton",120,"english");
        MovieService.createMovie("The Godfather","Francis Ford Coppola",177,"english");
        MovieService.createMovie("he Godfather: Part II","Francis Ford Coppola",200,"english");
        MovieService.createMovie("Eraserhead","David Lynch",129,"english");
        MovieService.createMovie("Blade Runner","Ridley Scott",117,"english");
        MovieService.createMovie("Top Gun","Tony Scott",110,"english");

        ShowService.createShow("Goldfinger","06/02/2001 12:10:54", Arrays.asList(Arrays.asList("Kolkata","Inox"),
                                                                                                    Arrays.asList("Hydrabad","Inox"),
                                                                                                    Arrays.asList("Bengaluru","Inox"),
                                                                                                    Arrays.asList("Chennai","Inox"),
                                                                                                    Arrays.asList("Mumbai","Pvr"),
                                                                                                    Arrays.asList("Kolkata","Pvr"),
                                                                                                    Arrays.asList("Gurgaon","Multiplex"),
                                                                                                    Arrays.asList("Mumbai","Multiplex")), theaterOwnerService);

        ShowService.createShow("Thunderball","10/03/2003 11:09:10", Arrays.asList(Arrays.asList("Kolkata","Multiplex"),
                Arrays.asList("Hydrabad","Multiplex"),
                Arrays.asList("Bengaluru","Multiplex"),
                Arrays.asList("Chennai","Pvr"),
                Arrays.asList("Mumbai","Multiplex"),
                Arrays.asList("Kolkata","Multiplex"),
                Arrays.asList("Gurgaon","Inox"),
                Arrays.asList("Mumbai","Inox")), theaterOwnerService);


        MovieService.getShowByMovieNameAndCity("Goldfinger","Kolkata").forEach(list-> System.out.println(list.getMovie().getMovieName()+" "+list.getStartTime()+" "+list.getTheaters().size()));
        ShowService.getShowByCity("Kolkata").forEach(list->{
            System.out.println(list.getMovie().getMovieName()+" "+list.getStartTime()+" "+list.getTheaters().size());
        });

        ShowService.getShowByTime("10/12/2002 10:13:13").forEach(list->{
            System.out.println(list.getMovie().getMovieName()+" "+list.getStartTime()+" "+list.getTheaters().size());
        });

        System.out.println(SearchService.getShowByMovieNameTheaterNameCityTime("Goldfinger","Kolkata","Inox","06/02/2001 12:10:54"));

        CompletableFuture<Void> future1= CompletableFuture.runAsync(()->{
            System.out.println("first");
            try {
                BookingService.createBooking("Inox","Kolkata","06/02/2001 12:10:54","Goldfinger",Arrays.asList(1,2),theaterOwnerService);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Void> future2= CompletableFuture.runAsync(()->{
            System.out.println("second");
            try {
                BookingService.createBooking("Inox","Kolkata","06/02/2001 12:10:54","Goldfinger",Arrays.asList(2,3),theaterOwnerService);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> future = CompletableFuture.allOf(future1,future2);
        try {
            future.get();
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }

//        BookingService.createBooking("Inox","Kolkata","06/02/2001 12:10:54","Goldfinger",Arrays.asList(1,2),theaterOwnerService);
//        BookingService.createBooking("Inox","Kolkata","06/02/2001 12:10:54","Goldfinger",Arrays.asList(2,3),theaterOwnerService);
    }
}