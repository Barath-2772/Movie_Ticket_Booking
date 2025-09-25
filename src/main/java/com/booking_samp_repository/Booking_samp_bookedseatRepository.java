package com.booking_samp_repository;

import com.booking_samp_modal.Booking_samp_bookedseat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface Booking_samp_bookedseatRepository extends JpaRepository<Booking_samp_bookedseat, Long> {
	
	 @Query("SELECT bs.seatNumber FROM Booking_samp_bookedseat bs WHERE bs.booking.show.id = :showId")
	    List<String> findSeatNumbersByShowId(@Param("showId") Long showId);
}