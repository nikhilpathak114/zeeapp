package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;


public interface MovieRepo {
	
	public String addMovies(Movies movie);
	public String deleteMovies(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException;
	public String modifyMovies(String id, Movies Movies) throws IdNotFoundException;
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException;
	public List<Movies> getAllMovies() throws InvalidNameException, InvalidIdLengthException, NameNotFoundException;
	public Optional<List<Movies>> getAllMoviesDetails() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException;

}