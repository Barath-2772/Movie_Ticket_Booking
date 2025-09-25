package com.booking_samp_service;

import com.booking_samp_modal.Booking_samp_city;
import com.booking_samp_modal.Booking_samp_theater;
import com.booking_samp_repository.Booking_samp_cityRepository;
import com.booking_samp_repository.Booking_samp_theaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Booking_samp_theater_Service {

    @Autowired
    private Booking_samp_theaterRepository theaterRepository;

    @Autowired
    private Booking_samp_cityRepository cityRepository;

    
    public Booking_samp_theater createTheater(Long cityId, Booking_samp_theater theater) {
        // Step 1: Find the parent city from the database
        Booking_samp_city city = cityRepository.findById(cityId).orElse(null);

        if (city != null) {
            // Step 2: Link the new theater to the city we found
            theater.setCity(city);
            
            // Step 3: Save the new theater
            return theaterRepository.save(theater);
        }
        return null; // Or throw an exception if the city doesn't exist
    }
}