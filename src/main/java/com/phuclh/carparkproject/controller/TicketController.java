package com.phuclh.carparkproject.controller;


import com.phuclh.carparkproject.dto.request.TicketRequestDTO;
import com.phuclh.carparkproject.dto.response.TicketResponseDTO;
import com.phuclh.carparkproject.entity.Ticket;
import com.phuclh.carparkproject.service.impl.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final ModelMapper modelMapper;

    @Autowired
    public TicketController(TicketService ticketService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addTicket(@RequestBody @Valid TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = modelMapper.map(ticketRequestDTO, Ticket.class);
        return new ResponseEntity<>(ticketService.addTicket(ticket), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllTickets(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "3") int pageSize) {
        List<TicketResponseDTO> tickets = ticketService.getAllTickets(pageNumber, pageSize).stream().map(ticket -> modelMapper.map(ticket, TicketResponseDTO.class)).collect(Collectors.toList());
        if (tickets.isEmpty()) {
            return new ResponseEntity<>("Empty list", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getTicketById(@PathVariable("id") long id) {
        return new ResponseEntity<>(modelMapper.map(ticketService.getTicketById(id), TicketResponseDTO.class), HttpStatus.OK);
    }

    //adding trip and car to ticket
    @PutMapping(value = "{ticketId}/{licensePlate}/{tripId}")
    public ResponseEntity<?> addCarAndTripToTicket(@PathVariable("ticketId") long ticketId, @PathVariable("licensePlate") String licensePlate, @PathVariable("tripId") long tripId) {
        return new ResponseEntity<>(ticketService.addCarAndTripToTicket(ticketId, licensePlate, tripId), HttpStatus.CREATED);
    }
}
