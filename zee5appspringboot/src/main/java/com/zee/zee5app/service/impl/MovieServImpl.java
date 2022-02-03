package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MovieRepo;
import com.zee.zee5app.service.MovieServ;

@Service
public class MovieServImpl implements MovieServ {
	
	@Autowired
	private MovieRepo repository ;

	@Override
	public String deleteMovie(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Movies> optional = this.getMovieById(id);
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
	public String modifyMovie(String id, Movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movies> getMovieById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Movies[] getAllMovie() throws InvalidNameException, NameNotFoundException, InvalidIdLengthException{
		// TODO Auto-generated method stub
		List<Movies> list = repository.findAll();
		Movies[] array = new Movies[list.size()];
		
		return list.toArray(array);
	}

	@Override
	public String addMovies(Movies movie) {
		// TODO Auto-generated method stub
		Movies movies = repository.save(movie);
		if(movies!=null) {
		 return "Success";
		}
		else return "Failed";
	}

	@Override
	public Optional<List<Movies>> getAllMoviesDetails() throws InvalidNameException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

}
