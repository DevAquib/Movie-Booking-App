package com.example.MovieBookingApp.Service;

import com.example.MovieBookingApp.DTO.MovieDTO;
import com.example.MovieBookingApp.Entity.Movie;
import com.example.MovieBookingApp.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(MovieDTO movieDTO){
        Movie movie=new Movie();
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());
        movie.setLanguage(movieDTO.getLanguage());


        return movieRepository.save(movie);
    }
}
