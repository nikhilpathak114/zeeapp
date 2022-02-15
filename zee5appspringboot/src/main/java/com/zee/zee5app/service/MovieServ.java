package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

public interface MovieServ {
	
	public Movies addMovie(Movies movie) throws AlreadyExistsException;
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException;
	public Movies[] getAllMovies();
	public String deleteMovie(String id) throws IdNotFoundException;
	public Optional<List<Movies>> getAllMovieDetails();

}