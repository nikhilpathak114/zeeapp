package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MovieRepo;

public class MovieServ {

	private MovieRepo movrepository = MovieRepo.getInstance();
	//service is consuming the repository
	
	private MovieServ(){
		
	}
	//if we want to create that single object then we have to create it
	//inside the same class'
	//and we have to share ref with others
	//to do the same we have to declare a method.
	private static MovieServ movservice = null;
	// this would be a static ref
	//only one copy
	
	public static MovieServ getInstance() {
		//it becomes object independent??
		// static will make it independent on the object for execution.
		
		// static method will only acces static ref
		if(movservice == null)
			movservice = new MovieServ();
		return movservice;
		
	}
	
	public String addMovies(Movies movie1) {
		//we need to consume the adduser method from repo.
		return this.movrepository.addMovies(movie1);
	}
	
	public Movies getMoviesById(String id) {
		return this.movrepository.getMoviesById(id);
	}
	
	public Movies[] getMovies() {
		return movrepository.getMovies();
	}
	
	public Movies getupdateMovies(String id, Movies movies) {
		return this.movrepository.getupdateMovies(id, movies);
	}
	
	public Movies getdeleteMovies(String id, Movies movies) {
		return movrepository.getdeleteMovies(id, movies);
	}
}
