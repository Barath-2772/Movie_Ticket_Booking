package com.booking_samp_service;

import com.booking_samp_modal.Booking_samp_user;
import com.booking_samp_repository.Booking_samp_userRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Add this import
import org.springframework.stereotype.Service;

@Service
public class Booking_samp_user_Service {

    @Autowired
    private Booking_samp_userRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder; // Inject the password encoder

    public Booking_samp_user createUser(Booking_samp_user user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    
 // Method to log in a user
    public Optional<Booking_samp_user> loginUser(String email, String password) {
        // Find the user by their email address
        Optional<Booking_samp_user> optionalUser = userRepository.findByEmail(email);

        // If user exists and password matches, return the user
        if (optionalUser.isPresent()) {
            Booking_samp_user user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return optionalUser;
            }
        }

        // Return empty if user not found or password doesn't match
        return Optional.empty();
    }
}