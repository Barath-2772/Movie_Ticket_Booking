package com.booking_samp_controller;

import com.booking_samp_dto.BookedseatDTO;
import com.booking_samp_dto.BookingRequest;
import com.booking_samp_modal.Booking_samp_booking;
import com.booking_samp_repository.Booking_samp_bookedseatRepository;
import com.booking_samp_repository.Booking_samp_bookingRepository;
import com.booking_samp_service.Booking_samp_booking_Service;

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
//@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*") 

@RequestMapping("/api/bookings")
public class Booking_samp_booking_Controller {

    @Autowired
    private Booking_samp_booking_Service bookingService;
    
    @Autowired
    private Booking_samp_bookingRepository bookingRepository;


    @PostMapping
    public Booking_samp_booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }
    
    @GetMapping("/by-user/{userId}")
    public List<BookedseatDTO> getBookingsByUser(@PathVariable Long userId) {
        List<Booking_samp_booking> bookings = bookingRepository.findByUserId(userId);
        return bookings.stream()
                       .map(BookedseatDTO::new)
                       .toList();
    }


}