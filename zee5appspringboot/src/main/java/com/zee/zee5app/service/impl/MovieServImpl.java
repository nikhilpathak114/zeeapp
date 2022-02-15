package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepo;
import com.zee.zee5app.service.MovieServ;

@Service
public class MovieServImpl implements MovieServ {
	
	@Autowired
	private MovieRepo movieRepository;

	@Override
	public Movies addMovie(Movies movie) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(movieRepository.existsById(movie.getId())) {
			throw new AlreadyExistsException("This record already exists");
		}
		Movies movie2 = movieRepository.save(movie);
		return movie2;
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional = movieRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id does not exist");
		}
		return optional;
	}

	@Override
	public Movies[] getAllMovies() {
		// TODO Auto-generated method stub
		List<Movies> list = movieRepository.findAll();
		Movies[] movies = new Movies[list.size()];
		return list.toArray(movies);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional = this.getMovieById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			movieRepository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Movies>> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

}
