package com.booking_samp_modal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "movies")
public class Booking_samp_movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Integer durationInMinutes;
    
    private String likes;   // e.g., "216.9K Likes"
    private String rating;  // e.g., "9.3/10"
    private String genre;   
    
    
    private String posterUrl;

    public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@JsonManagedReference("movie-show")
    @OneToMany(mappedBy = "movie")
    private List<Booking_samp_show> shows;

    // --- Manual Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }
    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    public List<Booking_samp_show> getShows() {
        return shows;
    }
    public void setShows(List<Booking_samp_show> shows) {
        this.shows = shows;
    }
    

    // ADD GETTER AND SETTER FOR posterUrl
    public String getPosterUrl() {
        return posterUrl;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}