package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.SeriesRepo;
@Component
public class SeriesRepoImpl implements SeriesRepo {

	//private Series[] seriess = new Series[10];
	//private static int count = -1;
	
	private TreeSet<Series> treeSet = new TreeSet<>();
	
	
	private static SeriesRepoImpl seriesRepo;
	public static SeriesRepoImpl getInstance() {
		if(seriesRepo==null)
			seriesRepo = new SeriesRepoImpl();
		return seriesRepo;
	}
	
	private SeriesRepoImpl() {
		
	}
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		boolean result = this.treeSet.add(series);
		if(result)
		{
			return "series added successfully";
		}
		else
		{
			return "failed to add series";
		}
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Series> optional = this.getSeriesById(id);
		
		if(optional.isPresent())
		{
			boolean result = treeSet.remove(optional.get());
			if(result)
			{
				return "Succesfully removed";
			}
			else
			{
				return "Failed";
			}
		}

		return "fail";
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteSeries(id);
		if(result=="Failed")
			return "Failed to delete series";
		result = this.addSeries(series);
		if(result=="Fail")
			return "Failed to add Series";
		return "Series Modified";
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		Series series2 = null;
		for (Series series : treeSet) {
			if(series.getId().equals(id))
			{
				//return Optional.of(subscription);
				series2 = series;
			}
		}
		return Optional.ofNullable(Optional.of(series2).orElseThrow(()-> new IdNotFoundException("id not found")));
	}


	@Override
	public List<Series> getAllSeries() {
		// TODO Auto-generated method stub
        List<Series> arrlist = new ArrayList<>(treeSet);
        Collections.sort(arrlist);
        return arrlist;
	}
}
