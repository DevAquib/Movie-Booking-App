package com.example.MovieBookingApp.Controller;

import com.example.MovieBookingApp.DTO.MovieDTO;
import com.example.MovieBookingApp.Entity.Movie;
import com.example.MovieBookingApp.Service.MovieService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @PostMapping("/addmovie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.addMovie(movieDTO));
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<List<Movie>>getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/getmoviesbygenre")
    public ResponseEntity<List<Movie>>getMovieByGenre(@RequestParam String genre){
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/getmoviesbylanguage")
    public ResponseEntity<List<Movie>>getMoviesByLanguage(@RequestParam String language){
        return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
    }

    @GetMapping("/getmoviesbytitle")
    public ResponseEntity<Movie>getMovieByTitle(@RequestParam String title){
        return ResponseEntity.ok(movieService.getMoviesByTitle(title));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updatemovie/{id}")
    public ResponseEntity<Movie>updateMovie(@PathVariable Long id, @RequestParam MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.updateMovie(id,movieDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletemovie/{id}")
    public ResponseEntity<Void>deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }


}
