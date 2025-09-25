package com.booking_samp_modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "theaters")
public class Booking_samp_theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @JsonBackReference("city-theater")
    @ManyToOne
    @JoinColumn(name = "city_id")
    private Booking_samp_city city;
    
    @JsonManagedReference("theater-show")
    @OneToMany(mappedBy = "theater", fetch = FetchType.EAGER) 
    private List<Booking_samp_show> shows;

    // --- Manual Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Booking_samp_city getCity() {
        return city;
    }
    public void setCity(Booking_samp_city city) {
        this.city = city;
    }
    public List<Booking_samp_show> getShows() {
        return shows;
    }
    public void setShows(List<Booking_samp_show> shows) {
        this.shows = shows;
    }
}