package com.phuclh.carparkproject.service;

import com.phuclh.carparkproject.entity.BookingOffice;
import com.phuclh.carparkproject.entity.Trip;

import java.util.List;

public interface IBookingOfficeService {
    BookingOffice addBookingOffice(BookingOffice bookingOffice);
    BookingOffice getBookingOfficeById(long id);
    List<BookingOffice> getAllBookingOffices(int pageNumber, int pageSize);
    BookingOffice addTripToBookingOffice(long bookingOfficeId, long tripId);
}
