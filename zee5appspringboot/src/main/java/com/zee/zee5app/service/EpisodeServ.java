package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

public interface EpisodeServ {
	
	public Episodes addEpisode(Episodes episode) throws AlreadyExistsException;
	public Optional<Episodes> getEpisodeById(String id) throws IdNotFoundException;
	public Episodes[] getAllEpisode();
	public String deleteEpisode(String id) throws IdNotFoundException;
	public Optional<List<Episodes>> getAllEpisodeDetails();

}