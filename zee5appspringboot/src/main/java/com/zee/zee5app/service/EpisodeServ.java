package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;

@Service
public interface EpisodeServ {
	
	public String addEpisode(Episodes episode);
	public Optional<Episodes> getEpisodeById(String id);
	public Episodes[] getAllEpisode();
	public String deleteEpisode(String id) throws IdNotFoundException;
	public Optional<List<Episodes>> getAllEpisodeDetails();

}