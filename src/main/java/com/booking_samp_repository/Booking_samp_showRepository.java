package com.booking_samp_repository;

import com.booking_samp_modal.Booking_samp_movie;
import com.booking_samp_modal.Booking_samp_show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Booking_samp_showRepository extends JpaRepository<Booking_samp_show, Long> {

    // This is for finding movies in a city
    @Query("SELECT DISTINCT s.movie FROM Booking_samp_show s WHERE s.theater.city.id = :cityId")
    List<Booking_samp_movie> findMoviesByCity(@Param("cityId") Long cityId);

    // THIS IS THE METHOD YOU ARE MISSING
    @Query("SELECT s FROM Booking_samp_show s WHERE s.theater.city.id = :cityId AND s.movie.id = :movieId")
    List<Booking_samp_show> findShowsByCityAndMovie(@Param("cityId") Long cityId, @Param("movieId") Long movieId);
    
    // This is for finding shows in a specific theater
    @Query("SELECT s FROM Booking_samp_show s WHERE s.theater.id = :theaterId AND s.movie.id = :movieId")
    List<Booking_samp_show> findShowsByTheaterAndMovie(@Param("theaterId") Long theaterId, @Param("movieId") Long movieId);
}