package com.forge.Ticket.Booking.System.service;

import java.util.List;

import com.forge.Ticket.Booking.System.dto.MovieDto;


public interface MovieService {
	List<MovieDto> getAllMovies();
	MovieDto getMoviesById(Long id);
	MovieDto addMovie(MovieDto moviedto);
	void deleteMovie(Long id);
	MovieDto updateMovie(Long id, MovieDto moviedto);
	

}
