package com.forge.Ticket.Booking.System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forge.Ticket.Booking.System.dto.BookingDto;
import com.forge.Ticket.Booking.System.entity.Booking;
import com.forge.Ticket.Booking.System.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public BookingDto createBooking(BookingDto bookingdto) {
		// TODO Auto-generated method stub
		 Booking booking = modelMapper.map(bookingdto, Booking.class);
	        Booking savedBooking = bookingRepository.save(booking);
	        return modelMapper.map(savedBooking, BookingDto.class);
		
	}

	@Override
	public BookingDto getBookingById(Long id) {
		// TODO Auto-generated method stub
		Booking booking=bookingRepository.findById(id)
				.orElseThrow( ()-> new RuntimeException("Booking Not Found"));
		return modelMapper.map(booking, BookingDto.class);
	}

	@Override
	public void cancelBooking(Long id) {
		// TODO Auto-generated method stub
		if(!bookingRepository.existsById(id)) {
			throw new RuntimeException("Booking not found");
		}
		bookingRepository.deleteById(id);
	}

	@Override
	public List<BookingDto> getBookingByUserId(Long Id) {
		// TODO Auto-generated method stub
		return bookingRepository.findByUserId(Id)
				.stream().map(booking-> modelMapper.map(booking, BookingDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BookingDto> getBookingByMovieId(Long Id) {
		// TODO Auto-generated method stub
		return bookingRepository.findByMovieId(Id)
				.stream().map(booking-> modelMapper.map(booking, BookingDto.class))
				.collect(Collectors.toList());
	}

}
