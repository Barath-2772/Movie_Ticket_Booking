package com.booking_samp_controller;

import com.booking_samp_modal.Booking_samp_city;
import com.booking_samp_service.Booking_samp_city_Service; // IMPORT the service

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
//@CrossOrigin(origins = "http://localhost:5173") 
//@CrossOrigin(origins ="*") 

public class Booking_samp_city_Controller {

    // The Controller now talks to the Service
    @Autowired
    private Booking_samp_city_Service cityService;

    @PostMapping("/insert")
    public Booking_samp_city InsertCity(@RequestBody Booking_samp_city city) {
        // The Controller delegates the work to the Service
        return cityService.InsertCity(city);
    }
    
    @GetMapping("/get_cities")
    public List<Booking_samp_city> GetCity() {
    	return cityService.GetCity();
    }
}