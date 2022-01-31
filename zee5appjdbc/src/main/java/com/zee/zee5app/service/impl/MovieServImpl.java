package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepo;
import com.zee.zee5app.service.MovieServ;
import com.zee.zee5app.repository.impl.*;

@Service
public class MovieServImpl implements MovieServ {

	private MovieRepo repository = MovieRepoImpl.getInstance();
	private static MovieServ service;	
	
//	public static MovieServ getInstance() throws IOException {
//		if(service == null)
//			service = new MovieServImpl();
//		return service;
//	}
	
    private MovieServImpl() throws IOException {
		
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return this.repository.deleteMovies(id);
	}

	@Override
	public String modifyMovie(String id, Movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.modifyMovies(id, movie);
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return this.repository.getMovieById(id);
	}

	@Override
	public List<Movies> getAllMovie() throws InvalidNameException, NameNotFoundException, InvalidIdLengthException{
		// TODO Auto-generated method stub
		return this.repository.getAllMovies();
	}

	@Override
	public String addMovies(Movies movie) {
		// TODO Auto-generated method stub
		return this.repository.addMovies(movie);	}

	@Override
	public Optional<List<Movies>> getAllMoviesDetails() throws InvalidNameException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return this.repository.getAllMoviesDetails();
	}

}
