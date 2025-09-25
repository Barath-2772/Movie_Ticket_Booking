package com.booking_samp_controller;

import com.booking_samp_modal.Booking_samp_user;
import com.booking_samp_service.Booking_samp_user_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class Booking_samp_user_Controller {

    @Autowired
    private Booking_samp_user_Service userService; // This MUST match the class name above

    @PostMapping("/create")
    public Booking_samp_user createUser(@RequestBody Booking_samp_user user) {
        return userService.createUser(user);
    }
}