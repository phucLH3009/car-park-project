package com.phuclh.carparkproject.service;

import com.phuclh.carparkproject.entity.BookingOffice;
import com.phuclh.carparkproject.entity.Trip;

import java.util.List;

public interface ITripService {
    Trip addTrip(Trip trip);
    Trip getTripById(long id);
    List<Trip> getAllTrips(int pageNumber, int pageSize);
}
