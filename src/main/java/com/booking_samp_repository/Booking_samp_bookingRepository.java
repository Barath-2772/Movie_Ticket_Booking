package com.booking_samp_repository;

import com.booking_samp_modal.Booking_samp_booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking_samp_bookingRepository extends JpaRepository<Booking_samp_booking, Long> {
    List<Booking_samp_booking> findByUserId(Long userId);
}
