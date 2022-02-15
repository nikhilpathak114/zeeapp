package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;

@Repository
public interface MovieRepo extends JpaRepository<Movies, String> {
	
	//find a movie details by title/moviename
	Optional<Movies> findByMovieName(String movieName);
	
	//find a movie details by moviename and rel date
	Optional<Movies> findByMovieNameAndReleaseDate(String movieName, String releaseDate);
	
	Optional<List<Movies>> findAllByCast(String cast);
	Optional<Movies> findByMovieNameAndLanguage(String movieName, String language);
	Boolean existsByMovieName(String movieName);
	
}
