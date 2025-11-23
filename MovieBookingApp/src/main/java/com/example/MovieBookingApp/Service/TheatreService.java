package com.example.MovieBookingApp.Service;

import com.example.MovieBookingApp.DTO.TheatreDTO;
import com.example.MovieBookingApp.Entity.Theatre;
import com.example.MovieBookingApp.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre addTheatre(TheatreDTO theatreDTO){
        Theatre theatre=new Theatre();

        theatre.setTheatreName(theatreDTO.getTheatreName());
        theatre.setTheatreCapacity(theatre.getTheatreCapacity());
        theatre.setTheatreLocation(theatre.getTheatreLocation());
        theatre.setTheatreScreenType(theatre.getTheatreScreenType());
        return theatreRepository.save(theatre);
    }

    public List<Theatre> getTheatreByLocation(String location){
        Optional<List<Theatre>> listOfTheatreBox=theatreRepository.findByLocation(location);
        if(listOfTheatreBox.isPresent()){
            return listOfTheatreBox.get();
        }
        else{
            throw new RuntimeException("No Theatres found for the location "+location);

        }
    }

    public Theatre updateTheatre(Long id,TheatreDTO theatreDTO){
        Theatre theatre=theatreRepository.findById(id).orElseThrow(()->new RuntimeException("No theatre found for id "+id));
        theatre.setTheatreName(theatreDTO.getTheatreName());
        theatre.setTheatreLocation(theatre.getTheatreName());
        theatre.setTheatreCapacity(theatre.getTheatreCapacity());
        theatre.setTheatreScreenType(theatre.getTheatreScreenType());

        return theatreRepository.save(theatre);

    }

    public void deleteTheatre(Long id){
        theatreRepository.deleteById(id);
    }
}
