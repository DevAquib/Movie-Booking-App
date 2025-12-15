package com.example.MovieBookingApp.Repository;

import com.example.MovieBookingApp.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TheatreRepository extends JpaRepository<Theatre,Long> {

    Optional<List<Theatre>>findByTheatreLocation(String theatreLocation);
}
