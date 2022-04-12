package com.phuclh.carparkproject.service.impl;

import com.phuclh.carparkproject.entity.ParkingLot;
import com.phuclh.carparkproject.exception.ExistedException;
import com.phuclh.carparkproject.exception.NotFoundException;
import com.phuclh.carparkproject.repository.ParkingLotRepository;
import com.phuclh.carparkproject.service.IParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService implements IParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        if (parkingLotRepository.findById(parkingLot.getId()).isPresent()) {
            throw new ExistedException("Parking Lot with this id " + parkingLot.getId() + " existed!");
        }
        return parkingLotRepository.saveAndFlush(parkingLot);
    }

    @Override
    public ParkingLot getParkingLotById(long id) {
        return parkingLotRepository.findById(id).orElseThrow(() -> new NotFoundException("Parking lot with this id " + id + " not found!"));
    }

    @Override
    public List<ParkingLot> getAllParkingLots(int pageNumber, int pageSize) {
        return parkingLotRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
}
