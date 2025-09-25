package com.booking_samp_controller;

import com.booking_samp_modal.Booking_samp_theater;
import com.booking_samp_service.Booking_samp_theater_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Note: Base path is now just /api
public class Booking_samp_theater_Controller {

    @Autowired
    private Booking_samp_theater_Service theaterService;

    @PostMapping("/cities/{cityId}/theaters")
    public Booking_samp_theater createTheater(
            @PathVariable Long cityId,
            @RequestBody Booking_samp_theater theater
    ) {
        return theaterService.createTheater(cityId, theater);
    }
}