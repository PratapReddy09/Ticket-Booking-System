package com.forge.Ticket.Booking.System.dto;

import com.forge.Ticket.Booking.System.entity.Theatre;

import lombok.Data;

@Data
public class ScreenDto {
	
	private Long id;
	private String screenName;
	private Theatre theatre;

}
