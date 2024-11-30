package com.forge.Ticket.Booking.System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forge.Ticket.Booking.System.dto.MovieDto;
import com.forge.Ticket.Booking.System.entity.Movie;
import com.forge.Ticket.Booking.System.repository.MovieRepository;
import com.forge.Ticket.Booking.System.exceptions.MovieNotFoundException;
import com.forge.Ticket.Booking.System.exceptions.MovieAlreadyExistsException;

@Service
public class MovieServiceImpl implements MovieService{
	
	private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Autowired
	private MovieRepository  MRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<MovieDto> getAllMovies() {
		// TODO Auto-generated method stub
		logger.info("Fetching All Movies");
		List<MovieDto> movies=MRepository.findAll().stream()
				.map(movie -> modelMapper.map(movie, MovieDto.class))
				.collect(Collectors.toList());
		logger.info("Fetched {} movies", movies.size());
		return movies;
	}

	@Override
	public MovieDto getMoviesById(Long id) {
		// TODO Auto-generated method stub
		logger.info("Fetched movie with Id: {}", id);
		Movie movie= MRepository.findById(id)
				.orElseThrow( ()-> 
				{
					logger.error("Movie not found with ID: {}", id);
					return new MovieNotFoundException("Movie Not Found with ID:" +id);
				});
		return modelMapper.map(movie, MovieDto.class);
	}

	@Override
	public MovieDto addMovie(MovieDto moviedto) {
		
		logger.info("Adding a new movie {}", moviedto.getTitle());
		Movie movie = modelMapper.map(moviedto, Movie.class);
		if(MRepository.existsById(movie.getId())) {
			logger.error("Movie Already Exists with ID: {}", movie.getId());
			throw new MovieAlreadyExistsException("movie already exists with ID:" +movie.getId());
		}
		
		Movie savedMovie = MRepository.save(movie);
		logger.info("Movie added sucessfully with ID:{}", savedMovie.getId());
		return modelMapper.map(savedMovie, MovieDto.class);
	}

	@Override
	public void deleteMovie(Long id) {
		// TODO Auto-generated method stub
		logger.info("Deleting Movie with ID: {}", id);
		if(!MRepository.existsById(id)) {
			logger.error("movie not found with ID: {}", id);
			throw new  MovieNotFoundException("Movie Not Found with ID:" +id);
		}
		MRepository.deleteById(id);
		logger.info("Movie deleted successfully with ID:{}", id);
	}

	@Override
	public MovieDto updateMovie(Long id, MovieDto moviedto) {
		// TODO Auto-generated method stub
		logger.info("Updating movie with ID:{}", id);
		Movie movie=MRepository.findById(id).orElseThrow(()->{
			logger.error("Movie not found with ID:{}",  id);
			return new MovieNotFoundException("Movie not found with ID:" +id);
		});
		
		movie.setTitle(moviedto.getTitle());
		movie.setGenre(moviedto.getGenre());
		movie.setDuration(moviedto.getDuration());
		
		Movie updateMovie=MRepository.save(movie);
		logger.info("Movie updated successfully with ID:{}", updateMovie.getId());
		return modelMapper.map(updateMovie, MovieDto.class);
	}

	
}
