package com.phuclh.carparkproject.service.impl;

import com.phuclh.carparkproject.entity.BookingOffice;
import com.phuclh.carparkproject.entity.Trip;
import com.phuclh.carparkproject.exception.ExistedException;
import com.phuclh.carparkproject.exception.NotFoundException;
import com.phuclh.carparkproject.repository.BookingOfficeRepository;
import com.phuclh.carparkproject.service.IBookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingOfficeService implements IBookingOfficeService {

    private final BookingOfficeRepository bookingOfficeRepository;
    private final TripService tripService;

    @Autowired
    public BookingOfficeService(BookingOfficeRepository bookingOfficeRepository, TripService tripService) {
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.tripService = tripService;
    }

    @Override
    public BookingOffice addBookingOffice(BookingOffice bookingOffice) {
        if (bookingOfficeRepository.findById(bookingOffice.getId()).isPresent()) {
            throw new ExistedException("Booking office with this id " + bookingOffice.getId() + " existed!");
        }
        return bookingOfficeRepository.saveAndFlush(bookingOffice);
    }

    @Override
    public BookingOffice getBookingOfficeById(long id) {
        return bookingOfficeRepository.findById(id).orElseThrow(() -> new NotFoundException("Booking office with this id " + id + " not found!"));
    }

    @Override
    public List<BookingOffice> getAllBookingOffices(int pageNumber, int pageSize) {
        return bookingOfficeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public BookingOffice addTripToBookingOffice(long bookingOfficeId, long tripId) {
        Trip trip = tripService.getTripById(tripId);
        trip.getBookingOffices().add(getBookingOfficeById(bookingOfficeId));
        BookingOffice bookingOffice = getBookingOfficeById(bookingOfficeId);
        bookingOffice.setTrip(trip);
        return bookingOfficeRepository.saveAndFlush(bookingOffice);
    }
}
