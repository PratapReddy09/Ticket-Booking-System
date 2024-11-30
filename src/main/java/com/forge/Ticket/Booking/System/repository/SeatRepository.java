package com.forge.Ticket.Booking.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forge.Ticket.Booking.System.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

}
