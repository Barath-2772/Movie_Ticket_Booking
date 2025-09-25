package com.booking_samp_repository;

import com.booking_samp_modal.Booking_samp_user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking_samp_userRepository extends JpaRepository<Booking_samp_user, Long> {
	Optional<Booking_samp_user> findByEmail(String email);
}
