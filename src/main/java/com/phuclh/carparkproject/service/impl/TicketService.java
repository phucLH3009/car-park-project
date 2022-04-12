package com.phuclh.carparkproject.service.impl;

import com.phuclh.carparkproject.entity.Car;
import com.phuclh.carparkproject.entity.Ticket;
import com.phuclh.carparkproject.entity.Trip;
import com.phuclh.carparkproject.exception.ExistedException;
import com.phuclh.carparkproject.exception.NotFoundException;
import com.phuclh.carparkproject.repository.TicketRepository;
import com.phuclh.carparkproject.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {

    private final TicketRepository ticketRepository;
    private final CarService carService;
    private final TripService tripService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, CarService carService, TripService tripService) {
        this.ticketRepository = ticketRepository;
        this.carService = carService;
        this.tripService = tripService;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        if (ticketRepository.findById(ticket.getId()).isPresent()) {
            throw new ExistedException("Ticket with this id " + ticket.getId() + " existed!");
        }
        return ticketRepository.saveAndFlush(ticket);
    }

    @Override
    public Ticket getTicketById(long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket with this id " + id + " not found!"));
    }

    @Override
    public List<Ticket> getAllTickets(int pageNumber, int pageSize) {
        return ticketRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public Ticket addCarAndTripToTicket(long ticketId, String licensePlate, long tripId) {
        Car car = carService.getCarByLicensePlate(licensePlate);
        car.getTickets().add(getTicketById(ticketId));
        Trip trip = tripService.getTripById(tripId);
        trip.getTickets().add(getTicketById(ticketId));
        Ticket ticket = getTicketById(ticketId);
        ticket.setCar(car);
        ticket.setTrip(trip);
        return ticketRepository.saveAndFlush(ticket);
    }
}
