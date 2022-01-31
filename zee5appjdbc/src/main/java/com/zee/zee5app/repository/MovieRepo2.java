package com.zee.zee5app.repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;

@Component
@Repository
public class MovieRepo2 {
	
	private Movies[] movies = new Movies[10];
	private static int count = -1;
	
//	private MovieRepo2() {
//		// TODO Auto-generated constructor stub
//	}
	
	private static MovieRepo2 movieRepository;
//	public static MovieRepo2 getInstance() {
//		if(movieRepository==null)
//			movieRepository = new MovieRepo2();
//		return movieRepository;
//	}
//	
	public String addMovie(Movies movie) {
		
		if(count == movies.length-1) {
			Movies temp[] = new Movies[movies.length*4];
			System.arraycopy(movie, 0, temp, 0, movies.length);
			movies = temp;
			movies[++count] = movie;
			return "Success2";	
		}
		movies[++count] = movie;
		return "Success2";			
	}
	
	public String deleteMovie(String id) {
		return null;
	}
	
	public String modifyMovie(String id, Movies movie) {
		return null;
	}
	
	public Movies getMovieById(String id) {
		for (Movies movie : movies) {
			if(movie!=null && movie.getId().equals(id))
				return movie;	
		}
		return null;
	}
	
	public Movies[] getAllMovie() {
		return movies;
	}
	
	
}