package com.booking_samp_modal;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cities")
public class Booking_samp_city {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference("city-theater")
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER) // Add fetch type
    private List<Booking_samp_theater> theaters;

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
    public List<Booking_samp_theater> getTheaters() {
        return theaters;
    }
    public void setTheaters(List<Booking_samp_theater> theaters) {
        this.theaters = theaters;
    }
}