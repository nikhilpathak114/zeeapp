package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepo;


public class MovieRepoImpl implements MovieRepo {

	private HashSet<Movies> hashset = new LinkedHashSet<>();
	
	private MovieRepoImpl() {
		
	}
	
	private static MovieRepoImpl movieRepository;
	public static MovieRepoImpl getInstance() {
		if(movieRepository==null)
			movieRepository = new MovieRepoImpl();
		return movieRepository;
	}
	
	@Override
	public String addMovies(Movies movie) {
		// TODO Auto-generated method stub
		boolean result = this.hashset.add(movie);
		if(!result) {
	
		return "fail";
		}
		return null;
	}

	@Override
	public String deleteMovies(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional = this.getMoviesById(id);
		if (optional.isPresent()){
			boolean result = hashset.remove(optional.get());
		if(result) {
			return ("Success");
		}
		else
			return("fail");
	}
	return "fail";
	}

	@Override
	public String modifyMovies(String id, Movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional = this.getMoviesById(id);
		if(optional.isPresent()) {
			boolean result = hashset.remove(optional.get());
			hashset.add(movie);
			if(result) {
				return ("modified");
			}
			
		}
		return null;
	}

	@Override
	public Optional<Movies> getMoviesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Movies movie2 = null;
		for (Movies movie : hashset) {
			if(movie.getId().equals(id)) {
				movie2 = movie;
			    break;
		}
			
		}
	 return Optional.of(Optional.ofNullable(movie2).orElseThrow(()-> new IdNotFoundException("movie id not found")));
				
	}

	@Override
	public List<Movies> getAllMovies() {
		// TODO Auto-generated method stub
        List<Movies> arrlist = new ArrayList(hashset);
        Collections.sort(arrlist);
        return arrlist;
        
//        return new ArrayList<>(set.descendingSet())
        

	}
	
	
}	