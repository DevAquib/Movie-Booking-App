package com.example.MovieBookingApp.Service;

import com.example.MovieBookingApp.DTO.ShowDTO;
import com.example.MovieBookingApp.DTO.TheatreDTO;
import com.example.MovieBookingApp.Entity.Booking;
import com.example.MovieBookingApp.Entity.Movie;
import com.example.MovieBookingApp.Entity.Show;
import com.example.MovieBookingApp.Entity.Theatre;
import com.example.MovieBookingApp.Repository.MovieRepository;
import com.example.MovieBookingApp.Repository.ShowRepository;
import com.example.MovieBookingApp.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfoNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheatreRepository theatreRepository;


    public Show createShow(ShowDTO showDTO){
        Movie movie=movieRepository.findById(showDTO.getMovieId()).orElseThrow(()->new RuntimeException("No movie found for id "+showDTO.getMovieId()));
        Theatre theatre=theatreRepository.findById(showDTO.getTheatreId()).orElseThrow(()->new RuntimeException("No movie found for theatre "+showDTO.getTheatreId()));




        Show show=new Show();
        show.setShowTime(showDTO.getShowTime());
        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setPrice(showDTO.getPrice());

        return showRepository.save(show);
    }

    public List<Show> getAllShows(){
        return showRepository.findAll();
    }

    public List<Show>getShowsByMovie(Long movieId){
        Optional<List<Show>>showListBox=showRepository.findByMovieId(movieId);
        if(showListBox.isPresent()){
            return showListBox.get();
        }
        else throw new RuntimeException("No shows found for movie with id "+movieId);
    }

    public List<Show>getShowsByTheatre(Long theatreId){
        Optional<List<Show>>showListBox=showRepository.findByTheatreId(theatreId);
        if(showListBox.isPresent()){
            return showListBox.get();
        }
        else throw new RuntimeException("No shows found for theatre with id "+theatreId);
    }

    public Show updateShow(Long id, ShowDTO showDTO){
        Show show=showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No shows found for the id "+id));
        Movie movie=movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(()->new RuntimeException("No movie found for the id "+showDTO.getMovieId()));
        Theatre theatre=theatreRepository.findById(showDTO.getTheatreId())
                .orElseThrow(()->new RuntimeException("No theatre found for the id "+showDTO.getTheatreId()));

        show.setShowTime(showDTO.getShowTime());
        show.setPrice(showDTO.getPrice());
        show.setMovie(movie);
        show.setTheatre(theatre);

        return showRepository.save(show);



    }

    public void deleteShow(Long id){
        if(!showRepository.existsById(id)){
            throw new RuntimeException("No show available for the id "+id);
        }
        List<Booking>bookings=showRepository.findById(id).get().getBookings();
        if(bookings.isEmpty()){
            throw new RuntimeException("Cant delete show with existing bookings");
        }
        showRepository.deleteById(id);
    }






}
