package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.EpisodeRepo;
import com.zee.zee5app.service.EpisodeServ;

@Service
public class EpisodeServImpl implements EpisodeServ {
	
	private EpisodeRepo episodeRepository;
	public  EpisodeServImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addEpisode(Episodes episode) {
		// TODO Auto-generated method stub
		return episodeRepository.addEpisode(episode);
	}

	@Override
	public Optional<Episodes> getEpisodeById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return episodeRepository.getEpisodeById(id);
	}

	@Override
	public Episodes[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyEpisode(String id, Episodes episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return episodeRepository.modifyEpisode(id, episode);
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return episodeRepository.deleteEpisode(id);
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return episodeRepository.getAllEpisodeDetails();
	}

}