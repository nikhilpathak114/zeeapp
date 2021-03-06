package com.zee.zee5app.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MovieRepo2;

@Component
@Service
public class MovieServ2 {
	private MovieRepo2 repository ;
	private static MovieServ2 service = null;		
	
	public static MovieServ2 getInstance() {
		if(service == null)
			service = new MovieServ2();
		return service;
	}
	
	public String addMovie(Movies movie) {
		return this.repository.addMovie(movie);
	}
	
	public Movies getMovieById(String id) {
		return this.repository.getMovieById(id);
	}
	
	public Movies[] getAllMovies() {
		return repository.getAllMovie();
	}

}