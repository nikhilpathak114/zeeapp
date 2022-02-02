package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

public interface EpisodeRepo {
	
	public String addEpisode(Episodes episode);
	public Optional<Episodes> getEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	public Episodes[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException;
	public String modifyEpisode(String id, Episodes episode) throws IdNotFoundException;
	public String deleteEpisode(String id) throws IdNotFoundException;
	public Optional<List<Episodes>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException;

}