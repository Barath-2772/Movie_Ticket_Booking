package com.booking_samp_dto;

import java.util.List;

public class BookingRequest {
    private Long showId;
    private Long userId;
    private List<String> seatNumbers;

    // --- Manual Getters and Setters ---
    public Long getShowId() {
        return showId;
    }
    public void setShowId(Long showId) {
        this.showId = showId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<String> getSeatNumbers() {
        return seatNumbers;
    }
    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
}