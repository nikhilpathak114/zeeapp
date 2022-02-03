package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.EpisodeRepo;
import com.zee.zee5app.service.EpisodeServ;

@Service
public class EpisodeServImpl implements EpisodeServ {

	@Autowired
	private EpisodeRepo epirepository;

	@Override
	public String addEpisode(Episodes episode) {
		// TODO Auto-generated method stub
		Episodes episode2 = epirepository.save(episode);
		if (episode2!=null)
			return "Success";
		else
			return "Fail";
	}

	@Override
	public Optional<Episodes> getEpisodeById(String id) {
		// TODO Auto-generated method stub
		return epirepository.findById(id);
	}

	@Override
	public Episodes[] getAllEpisode() {
		// TODO Auto-generated method stub
		List<Episodes> list = epirepository.findAll();
		Episodes[] episodes = new Episodes[list.size()];
		return list.toArray(episodes);
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Episodes> optional = this.getEpisodeById(id);
			if (optional.isEmpty())
				throw new IdNotFoundException("Record not found");
			else {
				epirepository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodeDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(epirepository.findAll());
	}
}
