package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepo2;


public class SeriesServ2 {
	
	private SeriesRepo2 repository = SeriesRepo2.getInstance();
	private static SeriesServ2 service = null;		
	
	public static SeriesServ2 getInstance() {
		if(service == null)
			service = new SeriesServ2();
		return service;
	}
	
	public String addSeries(Series series) {
		return this.repository.addSeries(series);
	}
	
	public Series getSeriesById(String id) {
		return this.repository.getSeriesById(id);
	}
	
	public Series[] getAllSeries() {
		return repository.getAllSeries();
	}


}