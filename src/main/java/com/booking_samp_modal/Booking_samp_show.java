package com.booking_samp_modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
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
@Table(name = "shows")
public class Booking_samp_show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime showTime;

    @JsonBackReference("movie-show")
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Booking_samp_movie movie;

    @JsonBackReference("theater-show")
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Booking_samp_theater theater;
    
    @JsonManagedReference("show-booking")
    @OneToMany(mappedBy = "show")
    private List<Booking_samp_booking> bookings;

    // --- Manual Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getShowTime() {
        return showTime;
    }
    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
    public Booking_samp_movie getMovie() {
        return movie;
    }
    public void setMovie(Booking_samp_movie movie) {
        this.movie = movie;
    }
    public Booking_samp_theater getTheater() {
        return theater;
    }
    public void setTheater(Booking_samp_theater theater) {
        this.theater = theater;
    }
    public List<Booking_samp_booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking_samp_booking> bookings) {
        this.bookings = bookings;
    }
}