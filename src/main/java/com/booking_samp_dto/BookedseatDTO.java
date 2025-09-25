package com.booking_samp_dto;

import java.time.LocalDateTime;
import java.util.List;

import com.booking_samp_modal.Booking_samp_bookedseat;
import com.booking_samp_modal.Booking_samp_booking;

public class BookedseatDTO {
    public String movieTitle;
    public String theaterName;
    public String showTime;
    public List<String> seats;
    public Long bookingId;

    public BookedseatDTO(Booking_samp_booking booking) {
        this.movieTitle = booking.getShow() != null && booking.getShow().getMovie() != null
                          ? booking.getShow().getMovie().getTitle()
                          : "Unknown Movie";

        this.theaterName = booking.getShow() != null && booking.getShow().getTheater() != null
                          ? booking.getShow().getTheater().getName()
                          : "Unknown Theater";

        this.showTime = booking.getShow() != null && booking.getShow().getShowTime() != null
                        ? booking.getShow().getShowTime().toString()
                        : "N/A";

        this.seats = booking.getBookedSeats() != null && !booking.getBookedSeats().isEmpty()
                     ? booking.getBookedSeats().stream().map(s -> s.getSeatNumber()).toList()
                     : List.of("No seats");

        this.bookingId = booking.getId();
    }
}

	
