package com.phuclh.carparkproject.dto.request;


import com.phuclh.carparkproject.entity.Trip;

import java.time.LocalDate;

public class BookingOfficeRequestDTO {

    private String name;
    private Trip trip;
    private String phone;
    private String place;
    private long price;
    private LocalDate startContractDeadline;
    private LocalDate endContractDeadline;

    public BookingOfficeRequestDTO() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public LocalDate getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(LocalDate startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public LocalDate getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(LocalDate endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }
}
