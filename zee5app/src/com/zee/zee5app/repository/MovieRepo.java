package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;


public interface MovieRepo {
	
	public String addMovies(Movies Movies);
	public String deleteMovies(String id) throws IdNotFoundException;
	public String modifyMovies(String id, Movies Movies) throws IdNotFoundException;
	public Optional<Movies> getMoviesById(String id) throws IdNotFoundException;
	public List<Movies> getAllMovies();

}