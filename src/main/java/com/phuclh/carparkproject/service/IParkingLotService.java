package com.phuclh.carparkproject.service;

import com.phuclh.carparkproject.entity.ParkingLot;

import java.util.List;

public interface IParkingLotService {
    ParkingLot addParkingLot(ParkingLot parkingLot);
    ParkingLot getParkingLotById(long id);
    List<ParkingLot> getAllParkingLots(int pageNumber, int pageSize);
}
