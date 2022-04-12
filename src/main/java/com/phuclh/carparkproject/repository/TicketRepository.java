package com.phuclh.carparkproject.repository;

import com.phuclh.carparkproject.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>, PagingAndSortingRepository<Ticket, Long> {

}
