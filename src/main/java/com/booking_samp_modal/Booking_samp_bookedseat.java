package com.booking_samp_modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booked_seats")
public class Booking_samp_bookedseat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @JsonBackReference("booking-seat")
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking_samp_booking booking;

    // --- Manual Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public Booking_samp_booking getBooking() {
        return booking;
    }
    public void setBooking(Booking_samp_booking booking) {
        this.booking = booking;
    }
}