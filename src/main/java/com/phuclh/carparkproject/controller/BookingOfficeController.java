package com.phuclh.carparkproject.controller;

import com.phuclh.carparkproject.dto.request.BookingOfficeRequestDTO;
import com.phuclh.carparkproject.dto.response.BookingOfficeResponseDTO;
import com.phuclh.carparkproject.entity.BookingOffice;
import com.phuclh.carparkproject.service.impl.BookingOfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "api/v1/bookingoffices")
public class BookingOfficeController {

    private final BookingOfficeService bookingOfficeService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookingOfficeController(BookingOfficeService bookingOfficeService, ModelMapper modelMapper) {
        this.bookingOfficeService = bookingOfficeService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addBookingOffice(@RequestBody @Valid BookingOfficeRequestDTO bookingOfficeRequestDTO) {
        BookingOffice bookingOffice = modelMapper.map(bookingOfficeRequestDTO, BookingOffice.class);
        return new ResponseEntity<>(bookingOfficeService.addBookingOffice(bookingOffice), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllBookingOffices(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "3") int pageSize) {
        List<BookingOfficeResponseDTO> bookings = bookingOfficeService.getAllBookingOffices(pageNumber, pageSize).stream().map(bookingOffice -> modelMapper.map(bookingOffice, BookingOfficeResponseDTO.class)).collect(Collectors.toList());
        if (bookings.isEmpty()) {
            return new ResponseEntity<>("Empty list", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getBookingOfficeById(@PathVariable("id") long id) {
        return new ResponseEntity<>(modelMapper.map(bookingOfficeService.getBookingOfficeById(id), BookingOfficeResponseDTO.class), HttpStatus.OK);
    }

    //adding trip to booking office
    @PutMapping(value = "{bookingOfficeId}/{tripId}/")
    public ResponseEntity<?> addTripToBookingOffice(@PathVariable("bookingOfficeId") long bookingOfficeId, @PathVariable("tripId") long tripId) {
        return new ResponseEntity<>(bookingOfficeService.addTripToBookingOffice(bookingOfficeId, tripId), HttpStatus.CREATED);
    }
}
