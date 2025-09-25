package com.booking_samp_service;

import com.booking_samp_modal.Booking_samp_movie;
import com.booking_samp_repository.Booking_samp_movieRepository;
import com.booking_samp_repository.Booking_samp_showRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Booking_samp_movie_Service {

    @Autowired
    private Booking_samp_movieRepository movieRepository;

    @Autowired
    private Booking_samp_showRepository showRepository; 
    
    public Booking_samp_movie createMovie(Booking_samp_movie movie) {
        return movieRepository.save(movie);
    }

    public List<Booking_samp_movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public List<Booking_samp_movie> findMoviesByCity(Long cityId) {
        return showRepository.findMoviesByCity(cityId);
    }
    
}