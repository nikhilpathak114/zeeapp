package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Movies {
	
	private String id;
	private String movieName;
	private String category;
	private String releaseDate;
	private String trailerLink;
	private String cast;
	private int movieLength;
	private int movieageLimit;
	
}
