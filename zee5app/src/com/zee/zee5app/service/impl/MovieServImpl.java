package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepo;
import com.zee.zee5app.service.MovieServ;
import com.zee.zee5app.repository.impl.*;

public class MovieServImpl implements MovieServ {

	private MovieRepo repository = MovieRepoImpl.getInstance();
	private static MovieServ service;	
	
	public static MovieServ getInstance() {
		if(service == null)
			service = new MovieServImpl();
		return service;
	}
	
    private MovieServImpl() {
		
	}
    
	@Override
	public String addMovie(Movies movie) {
		// TODO Auto-generated method stub
		return this.repository.addMovies(movie);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteMovies(id);
	}

	@Override
	public String modifyMovie(String id, Movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.modifyMovies(id, movie);
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getMoviesById(id);
	}

	@Override
	public List<Movies> getAllMovie() {
		// TODO Auto-generated method stub
		return this.repository.getAllMovies();
	}

}
