package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Series {
	
	private String id;
	private String seriesName;
	private String category;
	private String releaseDate;
	private String trailerLink;
	private String cast;
	private int seriesLength;
	private int ageLimit;
	
}
