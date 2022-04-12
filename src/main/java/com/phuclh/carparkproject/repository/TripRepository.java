package com.phuclh.carparkproject.repository;

import com.phuclh.carparkproject.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TripRepository extends JpaRepository<Trip, Long>, PagingAndSortingRepository<Trip, Long> {

}
