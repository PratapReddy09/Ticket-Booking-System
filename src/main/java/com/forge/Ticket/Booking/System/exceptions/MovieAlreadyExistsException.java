package com.forge.Ticket.Booking.System.exceptions;

public class MovieAlreadyExistsException extends RuntimeException{

	public MovieAlreadyExistsException(String message) {
		super(message);
	}
}
