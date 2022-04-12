package com.phuclh.carparkproject.repository;

import com.phuclh.carparkproject.entity.BookingOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookingOfficeRepository extends JpaRepository<BookingOffice, Long>, PagingAndSortingRepository<BookingOffice, Long> {

}
