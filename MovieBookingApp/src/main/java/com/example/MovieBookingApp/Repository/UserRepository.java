package com.example.MovieBookingApp.Repository;

import com.example.MovieBookingApp.Entity.Booking;
import com.example.MovieBookingApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {


  
}
