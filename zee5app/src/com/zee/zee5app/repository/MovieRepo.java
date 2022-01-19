package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movies;

public class MovieRepo {
	
	private Movies[] movie = new Movies[20];
	private static int count = -1;
	
	public Movies[] getMovies() {
		return movie;
	}
	
	public String addMovies(Movies movie1) {
		if(count == movie.length-1) {
			Movies temp[] = new Movies[movie.length*2];
			
			System.arraycopy(movie, 0, temp, 0, movie.length);
			movie = temp;
			movie[++count] = movie1;
			
			
			return "success";
		}
		movie[++count] = movie1;
		return "success";
	}
	
	public Movies getMoviesById(String id) {
		
		//we need to traverse the array
		
		for (Movies movies : movie) {
			if(movies != null && movies.getId().equals(id)) {
				return movies;
			}
		}
		
		return null;
	}
	
	public String getupdateMovies(String id, Movies movies) {
		for(Movies currMovie : movie) {
			if(currMovie != null) {
				if(currMovie.getId().equals(id)) {
					currMovie.setMovieName(movies.getMovieName());
					currMovie.setCast(movies.getCast());
					currMovie.setCategory(movies.getCategory());
					currMovie.setMovieageLimit(movies.getMovieageLimit());
					currMovie.setMovieLength(movies.getMovieLength());
					currMovie.setReleaseDate(movies.getReleaseDate());
					currMovie.setTrailerLink(movies.getTrailerLink());
					return "updated";
				}
			}
		}
		
		return null;
	}
	
	public String getdeleteMovies(String id, Movies movies) {
		for (Movies delMovie : movie) {
			if(delMovie != null) {
				if(delMovie.getId().equals(id)) {
					continue;
				}
				Movies temp1[] = new Movies[movie.length];
				
				//we need to copy contents from old to new
				System.arraycopy(movie, 0, temp1, 0, movie.length);
				movie = temp1;
				movie[++count] = movies;
				
				
				return "success";
			}
		}
		return null;
	}
	
	private static MovieRepo movieRepository;
	public static MovieRepo getInstance() {
		if(movieRepository == null)
			movieRepository = new MovieRepo();
		return movieRepository;
	}
}
