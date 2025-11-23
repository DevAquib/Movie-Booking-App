package com.example.MovieBookingApp.Controller;

import com.example.MovieBookingApp.DTO.TheatreDTO;
import com.example.MovieBookingApp.Entity.Theatre;
import com.example.MovieBookingApp.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatre")

public class TheatreController {

    @Autowired
    private TheatreService theatreService;


    @PostMapping("/addtheatre")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theatre> addTheatre(@RequestBody TheatreDTO theatreDTO){
        return ResponseEntity.ok(theatreService.addTheatre(theatreDTO));
    }

    @GetMapping("/gettheatrebylocation")
    public ResponseEntity<List<Theatre>>getTheatreByLocation(@RequestParam String location){
        return ResponseEntity.ok(theatreService.getTheatreByLocation(location));
    }

    @PutMapping("/updatetheatre")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable Long id,@RequestBody TheatreDTO theatreDTO){
        return ResponseEntity.ok(theatreService.updateTheatre(id,theatreDTO));
    }

    @DeleteMapping("/deletetheatre/{id}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable Long id){
        theatreService.deleteTheatre(id);
        return ResponseEntity.ok().build();
    }




}
