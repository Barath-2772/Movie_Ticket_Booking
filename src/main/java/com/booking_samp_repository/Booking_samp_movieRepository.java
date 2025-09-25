package com.booking_samp_repository;

import com.booking_samp_modal.Booking_samp_movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking_samp_movieRepository extends JpaRepository<Booking_samp_movie, Long> {
}