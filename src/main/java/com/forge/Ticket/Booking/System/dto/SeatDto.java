package com.forge.Ticket.Booking.System.dto;

import com.forge.Ticket.Booking.System.entity.Screen;

import lombok.Data;

@Data
public class SeatDto {
	
	private Long id;
	private String seatNumber;
	private boolean isAvailable;
	
	
	private Screen screen;

}
