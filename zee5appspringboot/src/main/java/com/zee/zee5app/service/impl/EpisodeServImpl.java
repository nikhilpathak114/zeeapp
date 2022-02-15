package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.EpisodeRepo;
import com.zee.zee5app.service.EpisodeServ;

@Service
public class EpisodeServImpl implements EpisodeServ {

	@Autowired
	private EpisodeRepo episodeRepository;

	@Override
	public Episodes addEpisode(Episodes episode) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(episodeRepository.existsById(episode.getId())) {
			throw new AlreadyExistsException("This record already exists");
		}
		Episodes episode2 = episodeRepository.save(episode);
		return episode2;
	}

	@Override
	public Optional<Episodes> getEpisodeById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episodes> optional = episodeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id does not exist");
		}
		return optional;
	}

	@Override
	public Episodes[] getAllEpisode() {
		// TODO Auto-generated method stub
		List<Episodes> list = episodeRepository.findAll();
		Episodes[] episodes = new Episodes[list.size()];
		return list.toArray(episodes);
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episodes> optional = this.getEpisodeById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			episodeRepository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodeDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodeRepository.findAll());
	}
}
