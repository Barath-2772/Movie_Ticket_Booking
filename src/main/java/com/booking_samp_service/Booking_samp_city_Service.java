package com.booking_samp_service;

import com.booking_samp_modal.Booking_samp_city;
import com.booking_samp_repository.Booking_samp_cityRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Booking_samp_city_Service {

    @Autowired
    private Booking_samp_cityRepository cityRepository;

    public Booking_samp_city InsertCity(Booking_samp_city city) {
        // In the future, complex logic like checking for duplicates
        // or data validation would go here.
        return cityRepository.save(city);
    }

	public List<Booking_samp_city> GetCity() {
		// TODO Auto-generated method stub
		return cityRepository.findAll();
	}

	
}