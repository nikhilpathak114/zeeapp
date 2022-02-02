package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.EpisodeRepo;

@Repository
public class EpisodeRepoImpl implements EpisodeRepo {
	
	@Autowired
	private DataSource dataSource;
	public EpisodeRepoImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addEpisode(Episodes episode) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String insertStatement = "INSERT INTO episodes"
				+ " (epiId, seriesId, name, length, location)"
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, episode.getId());
			preparedStatement.setString(2, episode.getSerId());
			preparedStatement.setString(3, episode.getName());
			preparedStatement.setFloat(4, episode.getLength());
			preparedStatement.setString(5, episode.getLocation());
			
			int result = preparedStatement.executeUpdate();
			
			if (result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
	}

	@Override
	public Optional<Episodes> getEpisodeById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM episodes WHERE epiId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Episodes episode = new Episodes();
				episode.setId(resultSet.getString("epiId"));
				episode.setSerId(resultSet.getString("seriesId"));
				episode.setName(resultSet.getString("name"));
				episode.setLength(resultSet.getFloat("length"));
				episode.setLocation(resultSet.getString("location"));
				return Optional.of(episode);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Episodes[] getAllEpisode() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Optional<List<Episodes>> optional = getAllEpisodeDetails();
		if(optional.isEmpty())
			return null;
		else {
			List<Episodes> list = optional.get();
			Episodes[] episodes = new Episodes[list.size()];
			return list.toArray(episodes);
		}
	}

	@Override
	public String modifyEpisode(String id, Episodes episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String updateStatement = "UPDATE episodes"
				+ " SET epiId = ?, seriesId = ?, name = ?, length = ?, location = ?"
				+ " WHERE (epiId = ?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, episode.getId());
			preparedStatement.setString(2, episode.getSerId());
			preparedStatement.setString(3, episode.getName());
			preparedStatement.setFloat(4, episode.getLength());
			preparedStatement.setString(5, episode.getLocation());
			preparedStatement.setString(6, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
	}

	@Override
	public String deleteEpisode(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String deleteStatement = "DELETE FROM episodes WHERE epiId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Fail";
		}
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodeDetails() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		ArrayList<Episodes> arrayList = new ArrayList<Episodes>();
		
		String selectStatement = "SELECT * FROM episodes";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Episodes episode = new Episodes();
				episode.setId(resultSet.getString("epiId"));
				episode.setSerId(resultSet.getString("seriesId"));
				episode.setName(resultSet.getString("name"));
				episode.setLength(resultSet.getFloat("length"));
				episode.setLocation(resultSet.getString("location"));
				arrayList.add(episode);
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

}