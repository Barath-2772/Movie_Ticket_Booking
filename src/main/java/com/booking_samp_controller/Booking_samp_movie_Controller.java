package com.booking_samp_controller;

import com.booking_samp_modal.Booking_samp_movie;
import com.booking_samp_service.Booking_samp_movie_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
//@CrossOrigin(origins = "http://localhost:5173") 
//@CrossOrigin(origins = "*") 

public class Booking_samp_movie_Controller {

    @Autowired
    private Booking_samp_movie_Service movieService;

    @PostMapping("/inserting")
    public Booking_samp_movie createMovie(@RequestBody Booking_samp_movie movie) {
        return movieService.createMovie(movie);
    }
    
    @GetMapping("/by-city/{cityId}")
    public List<Booking_samp_movie> getMoviesByCity(@PathVariable Long cityId) {
        return movieService.findMoviesByCity(cityId);
    }
    @GetMapping
    public List<Booking_samp_movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}