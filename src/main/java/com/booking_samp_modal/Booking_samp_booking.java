package com.booking_samp_modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking_samp_booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime bookingTime;

    @JsonBackReference("user-booking") // ADDED THIS ANNOTATION
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Booking_samp_user user;

    @JsonBackReference("show-booking") // ADDED THIS ANNOTATION
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Booking_samp_show show;
    
    @JsonManagedReference("booking-seat")
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Booking_samp_bookedseat> bookedSeats;

    // --- Manual Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
    public Booking_samp_user getUser() {
        return user;
    }
    public void setUser(Booking_samp_user user) {
        this.user = user;
    }
    public Booking_samp_show getShow() {
        return show;
    }
    public void setShow(Booking_samp_show show) {
        this.show = show;
    }
    public List<Booking_samp_bookedseat> getBookedSeats() {
        return bookedSeats;
    }
    public void setBookedSeats(List<Booking_samp_bookedseat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}