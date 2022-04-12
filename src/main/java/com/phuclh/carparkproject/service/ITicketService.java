package com.phuclh.carparkproject.service;

import com.phuclh.carparkproject.entity.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket addTicket(Ticket ticket);
    Ticket getTicketById(long id);
    List<Ticket> getAllTickets(int pageNumber, int pageSize);
    Ticket addCarAndTripToTicket(long ticketId, String licensePlate, long tripId);
}
