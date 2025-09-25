package com.booking_samp_service;

import com.booking_samp_dto.BookingRequest;
import com.booking_samp_modal.Booking_samp_booking;
import com.booking_samp_modal.Booking_samp_bookedseat;
import com.booking_samp_modal.Booking_samp_show;
import com.booking_samp_modal.Booking_samp_user;
import com.booking_samp_repository.Booking_samp_bookingRepository;
import com.booking_samp_repository.Booking_samp_showRepository;
import com.booking_samp_repository.Booking_samp_userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class Booking_samp_booking_Service {

    @Autowired
    private Booking_samp_bookingRepository bookingRepository;
    @Autowired
    private Booking_samp_showRepository showRepository;
    @Autowired
    private Booking_samp_userRepository userRepository;

    @Transactional
    public Booking_samp_booking createBooking(BookingRequest request) {
        Booking_samp_show show = showRepository.findById(request.getShowId()).orElse(null);
        Booking_samp_user user = userRepository.findById(request.getUserId()).orElse(null);

        if (show != null && user != null) {
            Booking_samp_booking newBooking = new Booking_samp_booking();
            newBooking.setShow(show);
            newBooking.setUser(user);
            newBooking.setBookingTime(LocalDateTime.now());

            List<Booking_samp_bookedseat> bookedSeats = new ArrayList<>();
            for (String seatNumber : request.getSeatNumbers()) {
                Booking_samp_bookedseat bookedSeat = new Booking_samp_bookedseat();
                bookedSeat.setSeatNumber(seatNumber);
                bookedSeat.setBooking(newBooking);
                bookedSeats.add(bookedSeat);
            }
            newBooking.setBookedSeats(bookedSeats);
            return bookingRepository.save(newBooking);
        }
        return null;
    }
    
    public List<Booking_samp_booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}