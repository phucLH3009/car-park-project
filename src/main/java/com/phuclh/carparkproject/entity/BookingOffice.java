package com.phuclh.carparkproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class BookingOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officeId", length = 20)
    private long id;

    @Column(name = "officeName", length = 50)
    @NotBlank(message = "name required")
    private String name;

    @Column(name = "officePhone", length = 11)
    @NotBlank(message = "phone required")
    private String phone;

    @Column(name = "officePlace", length = 50)
    @NotBlank(message = "place required")
    private String place;

    @Column(name = "officePrice", length = 20)
    @NotNull(message = "price required")
    private long price;

    @NotNull(message = "date required")
    private LocalDate startContractDeadline;

    @NotNull(message = "date required")
    private LocalDate endContractDeadline;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")
    private Trip trip;

    public BookingOffice() {
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

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
