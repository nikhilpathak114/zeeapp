package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SeriesRepo;
import com.zee.zee5app.service.SeriesServ;

@Service
public class SeriesServImpl implements SeriesServ {

	@Autowired
	private SeriesRepo repository;
    
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		repository.save(series);
		if(series!=null) {
		 return "Success";
		}
		else return "Failed";
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		List<Series> list = repository.findAll();
		Series[] array = new Series[list.size()];
		
		return list.toArray(array);
	}
	
	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

}
