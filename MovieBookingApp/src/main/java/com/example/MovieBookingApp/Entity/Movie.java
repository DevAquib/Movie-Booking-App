package com.example.MovieBookingApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movie {

    private  Long id;
    private String name;
    private String description;
    private String genre;
    private String language;
    private Integer duration;
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie" , fetch = FetchType.LAZY)
    private List<Show> show;

}
