package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepo;
@Repository
public interface MovieServ {
	
	public String addMovies(Movies movie);
	public String deleteMovie(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException, NameNotFoundException;
	public String modifyMovie(String id, Movies movie) throws IdNotFoundException;
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	public Movies[] getAllMovie() throws InvalidNameException, NameNotFoundException, InvalidIdLengthException;
	public Optional<List<Movies>> getAllMoviesDetails() throws InvalidNameException, NameNotFoundException, InvalidIdLengthException;
	
}