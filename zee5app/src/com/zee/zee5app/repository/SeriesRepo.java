package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;

public class SeriesRepo {

	private Series[] webseries = new Series[20];
	private static int count = -1;
	
	public Series[] getSeries() {
		return webseries;
	}
	
	public String addSeries(Series ottseries) {
		if(count == webseries.length-1) {
			 Series temp[] = new Series[webseries.length*2];
			
			System.arraycopy(webseries, 0, temp, 0, webseries.length);
			webseries = temp;
			webseries[++count] = ottseries;
			
			
			return "success";
		}
		webseries[++count] = ottseries;
		return "success";
	}
	
	public Series getSeriesById(String id) {
		
		//we need to traverse the array
		
		for (Series ottSeries : webseries) {
			if(ottSeries != null && ottSeries.getId().equals(id)) {
				return ottSeries;
			}
		}
		
		return null;
	}
	
	public String getupdateSeries(String id, Series ottSeries) {
		for(Series currSeries : webseries) {
			if( currSeries != null) {
				if(currSeries.getId().equals(id)) {
					currSeries.setAgeLimit(ottSeries.getAgeLimit());
					currSeries.setCast(ottSeries.getCast());
					currSeries.setCategory(ottSeries.getCategory());
					currSeries.setReleaseDate(ottSeries.getReleaseDate());
					currSeries.setSeriesLength(ottSeries.getSeriesLength());
					currSeries.setSeriesName(ottSeries.getSeriesName());;
					currSeries.setTrailerLink(ottSeries.getTrailerLink());
					return "updated";
				}
			}
		}
		
		return null;
	}
	
	public String getdeleteSeries(String id, Series ottSeries) {
		for (Series delSeries : webseries) {
			if(delSeries != null) {
				if(delSeries.getId().equals(id)) {
					continue;
				}
				Series temp1[] = new Series[webseries.length];
				
				//we need to copy contents from old to new
				System.arraycopy(webseries, 0, temp1, 0, webseries.length);
				webseries = temp1;
				webseries[++count] = ottSeries;
				
				
				return "success";
			}
		}
		return null;
	}
	
	private static SeriesRepo seriesRepository;
	public static SeriesRepo getInstance() {
		if(seriesRepository == null)
			seriesRepository = new SeriesRepo();
		return seriesRepository;
	}
	
}
