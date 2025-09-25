package com.booking_samp_dto;

import java.time.LocalDateTime;

public class ShowDTO {

    private Long id;
    private LocalDateTime showTime;
    private String movieTitle;
    private String theaterName;

    // --- Manual Getters and Setters ---
    public Long getId() 
    { 
    	return id; 
    	}
    public void setId(Long id)
    { 
    	this.id = id; 
    	}
    public LocalDateTime getShowTime() 
    {
    	return showTime;
    	}
    public void setShowTime(LocalDateTime showTime) 
    {
    	this.showTime = showTime; 
    	}
    public String getMovieTitle() 
    { 
    	return movieTitle; 
    	}
    public void setMovieTitle(String movieTitle)
    { 
    	this.movieTitle = movieTitle; 
    	}
    public String getTheaterName() 
    { return theaterName; }
    public void setTheaterName(String theaterName)
    { this.theaterName = theaterName; 
    }
}