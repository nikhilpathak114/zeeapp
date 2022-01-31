package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepo;

public interface MovieServ {
	
	public String addMovie(Movies movie);
	public String deleteMovie(String id) throws IdNotFoundException;
	public String modifyMovie(String id, Movies movie) throws IdNotFoundException;
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException;
	public List<Movies> getAllMovie();
	
}