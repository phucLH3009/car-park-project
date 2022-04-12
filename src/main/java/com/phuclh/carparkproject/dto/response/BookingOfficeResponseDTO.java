package com.phuclh.carparkproject.dto.response;

import com.phuclh.carparkproject.entity.Trip;

public class BookingOfficeResponseDTO {

    private long id;
    private String name;
    private Trip trip;

    public BookingOfficeResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
