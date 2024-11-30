package com.forge.Ticket.Booking.System.service;

import java.util.List;

import com.forge.Ticket.Booking.System.dto.BookingDto;

public interface BookingService {
	BookingDto createBooking(BookingDto bookingdto);
	BookingDto getBookingById(Long id);
	void cancelBooking(Long id);
	List<BookingDto> getBookingByUserId(Long userId);
	List<BookingDto> getBookingByMovieId(Long Id);
}
