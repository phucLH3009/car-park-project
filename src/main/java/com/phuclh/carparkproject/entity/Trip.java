package com.phuclh.carparkproject.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tripId", length = 20)
    private long id;

    @Min(0)
    @Column(length = 11)
    private int bookedTicketNumber;

    @Column(length = 50)
    private String carType;

    @NotNull(message = "date required")
    private LocalDate departureDate;

    @NotNull(message = "time required")
    private LocalTime departureTime;

    @Column(length = 50)
    @NotBlank(message = "destination required")
    private String destination;

    @Column(length = 50)
    @NotBlank(message = "driver required")
    private String driver;

    @Min(0)
    @Column(length = 11)
    @NotNull(message = "maximum online ticket number required")
    private int maximumOnlineTicketNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip", cascade = CascadeType.ALL)
    private List<BookingOffice> bookingOffices = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public Trip() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(int bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(int maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public List<BookingOffice> getBookingOffices() {
        return bookingOffices;
    }

    public void setBookingOffices(List<BookingOffice> bookingOffices) {
        this.bookingOffices = bookingOffices;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
