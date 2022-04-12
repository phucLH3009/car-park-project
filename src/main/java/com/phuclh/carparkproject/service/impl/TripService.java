package com.phuclh.carparkproject.service.impl;

import com.phuclh.carparkproject.entity.Trip;
import com.phuclh.carparkproject.exception.ExistedException;
import com.phuclh.carparkproject.exception.NotFoundException;
import com.phuclh.carparkproject.repository.TripRepository;
import com.phuclh.carparkproject.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService implements ITripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip addTrip(Trip trip) {
        if (tripRepository.findById(trip.getId()).isPresent()) {
            throw new ExistedException("Trip with this id " + trip.getId() + " existed");
        }
        return tripRepository.saveAndFlush(trip);
    }

    @Override
    public Trip getTripById(long id) {
        return tripRepository.findById(id).orElseThrow(() -> new NotFoundException("Trip with this id " + id + " not found!"));
    }

    @Override
    public List<Trip> getAllTrips(int pageNumber, int pageSize) {
        return tripRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

}
