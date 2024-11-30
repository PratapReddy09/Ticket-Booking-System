package com.forge.Ticket.Booking.System.dto;

import java.util.List;

import com.forge.Ticket.Booking.System.entity.Movie;
import com.forge.Ticket.Booking.System.entity.Screen;
import com.forge.Ticket.Booking.System.entity.Seat;
import com.forge.Ticket.Booking.System.entity.User;

import lombok.Data;


@Data
public class BookingDto {

private Long id;
	private User user;
	private Movie movie;
	private Screen screen;
	private List<Seat> seats;
	private String status;
	
}
