package com.booking_samp_controller;

import com.booking_samp_dto.ShowDTO;
import com.booking_samp_modal.Booking_samp_show;
import com.booking_samp_service.Booking_samp_show_Service;
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
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:5173") 
//@CrossOrigin(origins = "*") 

public class Booking_samp_show_Controller {

    @Autowired
    private Booking_samp_show_Service showService;

    @PostMapping("/theaters/{theaterId}/movies/{movieId}/shows")
    public Booking_samp_show createShow(
            @PathVariable Long theaterId,
            @PathVariable Long movieId,
            @RequestBody Booking_samp_show show
    ) {
        return showService.createShow(movieId, theaterId, show);
    }
    
    // Endpoint to get shows by a specific THEATER
//    @GetMapping("/theaters/{theaterId}/movies/{movieId}/shows")
//    public List<Booking_samp_show> getShowsByTheaterAndMovie(
//            @PathVariable Long theaterId,
//            @PathVariable Long movieId) {
//        return showService.findShowsByTheaterAndMovie(theaterId, movieId);
//    }

 // CHANGE THE RETURN TYPE of this method
    @GetMapping("/cities/{cityId}/movies/{movieId}/shows")
    public List<ShowDTO> getShowsByCityAndMovie(
            @PathVariable Long cityId,
            @PathVariable Long movieId) {
        return showService.findShowsByCityAndMovie(cityId, movieId);
    }
    
    
    @GetMapping("/shows/{showId}/booked-seats")
    public List<String> getBookedSeats(@PathVariable Long showId) {
        return showService.getBookedSeats(showId);
    }

}