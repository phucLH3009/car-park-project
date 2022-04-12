package com.phuclh.carparkproject.service;

import com.phuclh.carparkproject.entity.Car;

import java.util.List;

public interface ICarService {
    Car addCar(Car car);
    Car getCarByLicensePlate(String licensePlate);
    List<Car> getAllCars(int pageNumber, int pageSize);
    Car addParkingLotToCar(String licensePlate, long parkId);
}
