package com.zee.zee5app.service;


import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepo;

public class SeriesServ {

	private SeriesRepo serrepository = SeriesRepo.getInstance();
	//service is consuming the repository
	
	private SeriesServ(){
		
	}
	//if we want to create that single object then we have to create it
	//inside the same class'
	//and we have to share ref with others
	//to do the same we have to declare a method.
	private static SeriesServ serservice = null;
	// this would be a static ref
	//only one copy
	
	public static SeriesServ getInstance() {
		//it becomes object independent??
		// static will make it independent on the object for execution.
		
		// static method will only acces static ref
		if(serservice == null)
			serservice = new SeriesServ();
		return serservice;
		
	}
	
	public String addSeries(Series ottSeries) {
		//we need to consume the adduser method from repo.
		return this.serrepository.addSeries(ottSeries);
	}
	
	public Series getSeriesById(String id) {
		return this.serrepository.getSeriesById(id);
	}
	
	public Series[] getSeries() {
		return serrepository.getSeries();
	}
	
	public Series getupdateSeries(String id, Series ottSeries) {
		return this.serrepository.getupdateSeries(id, ottSeries);
	}
	
	public Series getdeleteSeries(String id, Series ottSeries) {
		return serrepository.getdeleteSeries(id, ottSeries);
	}
}
