package com.phuclh.carparkproject.controller;

import com.phuclh.carparkproject.dto.request.TripRequestDTO;
import com.phuclh.carparkproject.dto.response.EmployeeResponseDTO;
import com.phuclh.carparkproject.dto.response.TripResponseDTO;
import com.phuclh.carparkproject.entity.Trip;
import com.phuclh.carparkproject.service.impl.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "api/v1/trips")
public class TripController {

    private final TripService tripService;
    private final ModelMapper modelMapper;

    @Autowired
    public TripController(TripService tripService, ModelMapper modelMapper) {
        this.tripService = tripService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addTrip(@RequestBody @Valid TripRequestDTO tripRequestDTO) {
        Trip trip = modelMapper.map(tripRequestDTO, Trip.class);
        return new ResponseEntity<>(tripService.addTrip(trip), HttpStatus.CREATED);
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllTrips(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "3") int pageSize) {
        List<TripResponseDTO> trips = tripService.getAllTrips(pageNumber, pageSize).stream().map(trip -> modelMapper.map(trip, TripResponseDTO.class)).collect(Collectors.toList());
        if (trips.isEmpty()) {
            return new ResponseEntity<>("Empty list", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(trips, HttpStatus.OK);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getTripById(@PathVariable("id") long id) {
        return new ResponseEntity<>(modelMapper.map(tripService.getTripById(id), TripResponseDTO.class), HttpStatus.OK);
    }
}
