package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movies;

public interface MovieRepo2 {

	public String addMovies(Movies movie);
	public String updateMovies(String id, Movies movie);
	public Movies getMoviesById(String id);
	public Movies[] getMovies();
	public String deleteMoviesById(String id);
}
