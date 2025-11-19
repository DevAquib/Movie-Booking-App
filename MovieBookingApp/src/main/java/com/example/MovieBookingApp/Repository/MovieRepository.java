package com.example.MovieBookingApp.Repository;


import com.example.MovieBookingApp.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
