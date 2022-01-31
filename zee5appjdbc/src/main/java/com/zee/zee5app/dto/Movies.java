package com.zee.zee5app.dto;

import java.net.URL;
import java.lang.*;
import java.util.Objects;
import javax.naming.NameNotFoundException;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Movies implements Comparable<Movies>{
	
	
	public Movies(String id, String movieName,int ageLimit,String cast,String genre,double length, String trailer,String releaseDate,
			String language) throws InvalidIdLengthException, NameNotFoundException {
		super();
		this.setId(id);
		this.setMovieName(movieName);
		this.setAgeLimit(ageLimit);
		this.setCast(cast);
		this.setGenre(genre);
		
		this.setLength(length);
		this.setReleaseDate(releaseDate);
		this.setTrailer(trailer);
		this.setLanguage(language);
	}
	
	public Movies() {
		
	}


	@Setter(value = AccessLevel.NONE)
	private String movieName;
	
	private double length;
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	private String genre;
	
	private String releaseDate;
	private String trailer;
	private String Cast;
	private int ageLimit;
	private String language;
	
	


	@Override
	public int compareTo(Movies o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6) {
			throw new InvalidIdLengthException("id length less than 6");
		}
		this.id = id;

	}

	public void setMovieName(String movieName) throws NameNotFoundException {
		if(movieName == null) {
			throw new NameNotFoundException("movie name not found");
		}
		this.movieName = movieName;
	}

	public void setLanguage(String language) {
		// TODO Auto-generated method stub
		this.language = language;
	}
	
}