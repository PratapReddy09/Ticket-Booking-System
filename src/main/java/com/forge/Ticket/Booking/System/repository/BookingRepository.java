package com.forge.Ticket.Booking.System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forge.Ticket.Booking.System.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	List<Booking> findByUserId(Long Id);
	List<Booking> findByMovieId(Long Id);
}
