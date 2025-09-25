package com.booking_samp_service;

import com.booking_samp_dto.ShowDTO;
import com.booking_samp_modal.Booking_samp_movie;
import com.booking_samp_modal.Booking_samp_show;
import com.booking_samp_modal.Booking_samp_theater;
import com.booking_samp_repository.Booking_samp_bookedseatRepository;
import com.booking_samp_repository.Booking_samp_movieRepository;
import com.booking_samp_repository.Booking_samp_showRepository;
import com.booking_samp_repository.Booking_samp_theaterRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Booking_samp_show_Service {

    @Autowired
    private Booking_samp_showRepository showRepository;

    @Autowired
    private Booking_samp_movieRepository movieRepository;

    @Autowired
    private Booking_samp_theaterRepository theaterRepository;
    
    @Autowired
    private Booking_samp_bookedseatRepository bookedSeatRepository; 

    public Booking_samp_show createShow(Long movieId, Long theaterId, Booking_samp_show show) {
        // Step 1: Find the Movie and Theater from the database
        Booking_samp_movie movie = movieRepository.findById(movieId).orElse(null);
        Booking_samp_theater theater = theaterRepository.findById(theaterId).orElse(null);

        // Step 2: Make sure both the movie and theater exist
        if (movie != null && theater != null) {
            // Step 3: Link the show to the movie and theater
            show.setMovie(movie);
            show.setTheater(theater);

            // Step 4: Save the new show
            return showRepository.save(show);
        }
        
        // Return null if the movie or theater couldn't be found
        return null;
    }
    
 // ... inside the Booking_samp_showService class

  

 // CHANGE THE RETURN TYPE of this method
    public List<ShowDTO> findShowsByCityAndMovie(Long cityId, Long movieId) {
        // FIXED the typo in the method name below
        List<Booking_samp_show> shows = showRepository.findShowsByCityAndMovie(cityId, movieId);
        
        // Convert the list of Show entities to a list of ShowDTOs
        return shows.stream().map(show -> {
            ShowDTO dto = new ShowDTO();
            dto.setId(show.getId());
            dto.setShowTime(show.getShowTime());
            dto.setMovieTitle(show.getMovie().getTitle());
            dto.setTheaterName(show.getTheater().getName());
            return dto;
        }).collect(Collectors.toList());
    }
    
    
    public List<String> getBookedSeats(Long showId) {
        return bookedSeatRepository.findSeatNumbersByShowId(showId);
    }

	
}