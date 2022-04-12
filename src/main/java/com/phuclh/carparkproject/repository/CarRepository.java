package com.phuclh.carparkproject.repository;

import com.phuclh.carparkproject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long>, PagingAndSortingRepository<Car, Long> {
    Optional<Car> findCarByLicensePlate(String licensePlate);
}
