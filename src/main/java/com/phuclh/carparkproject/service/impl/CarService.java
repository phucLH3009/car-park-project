package com.phuclh.carparkproject.service.impl;

import com.phuclh.carparkproject.entity.Car;
import com.phuclh.carparkproject.entity.ParkingLot;
import com.phuclh.carparkproject.exception.ExistedException;
import com.phuclh.carparkproject.exception.NotFoundException;
import com.phuclh.carparkproject.repository.CarRepository;
import com.phuclh.carparkproject.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    private final CarRepository carRepository;
    private final ParkingLotService parkingLotService;

    @Autowired
    public CarService(CarRepository carRepository, ParkingLotService parkingLotService) {
        this.carRepository = carRepository;
        this.parkingLotService = parkingLotService;
    }

    @Override
    public Car addCar(Car car) {
        if (carRepository.findCarByLicensePlate(car.getLicensePlate()).isPresent()) {
            throw new ExistedException("Car with this license " + car.getLicensePlate() + " existed!");
        }
        return carRepository.saveAndFlush(car);
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return carRepository.findCarByLicensePlate(licensePlate).orElseThrow(() -> new NotFoundException("Car with license plate " + licensePlate + " not found!"));
    }

    @Override
    public List<Car> getAllCars(int pageNumber, int pageSize) {
        return carRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    @Override
    public Car addParkingLotToCar(String licensePlate, long parkId) {
        ParkingLot parkingLot = parkingLotService.getParkingLotById(parkId);
        parkingLot.getCars().add(getCarByLicensePlate(licensePlate));
        Car car = getCarByLicensePlate(licensePlate);
        car.setParkingLot(parkingLot);
        return carRepository.saveAndFlush(car);
    }
}
