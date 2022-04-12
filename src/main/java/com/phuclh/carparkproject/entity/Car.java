package com.phuclh.carparkproject.entity;

import com.phuclh.carparkproject.entity.ParkingLot;
import com.phuclh.carparkproject.entity.Ticket;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table
public class Car {

    @Id
    @Column(length = 50)
    private String licensePlate;

    @Column(name = "carColor", length = 11)
    private String color;

    @Column(name = "carType", length = 50)
    private String type;

    @Column(length = 50)
    @NotBlank(message = "company required")
    private String company;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parkId", referencedColumnName = "parkId")
    private ParkingLot parkingLot;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();


    public Car() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
