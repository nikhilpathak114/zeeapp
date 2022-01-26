package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepo;
import com.zee.zee5app.service.SeriesServ;
import com.zee.zee5app.repository.impl.*;

public class SeriesServImpl implements SeriesServ {

	private SeriesRepo repository = SeriesRepoImpl.getInstance();
	private static SeriesServ service;	
	
	public static SeriesServ getInstance() {
		if(service == null)
			service = new SeriesServImpl();
		return service;
	}
	
    private SeriesServImpl() {
		
	}
    
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return this.repository.addSeries(series);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteSeries(id);
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.modifySeries(id, series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getSeriesById(id);
	}

	@Override
	public List<Series> getAllSeries() {
		// TODO Auto-generated method stub
		return this.repository.getAllSeries();
	}

}
