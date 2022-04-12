package com.phuclh.carparkproject.repository;

import com.phuclh.carparkproject.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>, PagingAndSortingRepository<ParkingLot, Long> {

}
