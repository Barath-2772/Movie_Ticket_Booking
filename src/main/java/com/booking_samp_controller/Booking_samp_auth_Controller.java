package com.booking_samp_controller;

import com.booking_samp_dto.LoginRequest;
import com.booking_samp_modal.Booking_samp_user;
import com.booking_samp_service.Booking_samp_user_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:5173") 

//@CrossOrigin(origins = "*") 

public class Booking_samp_auth_Controller {

    @Autowired
    private Booking_samp_user_Service userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<Booking_samp_user> userOptional = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}