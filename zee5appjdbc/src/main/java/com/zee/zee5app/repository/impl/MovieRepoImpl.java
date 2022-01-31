package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepo;
import com.zee.zee5app.repository.MovieRepo2;
import com.zee.zee5app.utils.DBUtils;
@Component
@Repository
public class MovieRepoImpl implements MovieRepo {

	DBUtils dbUtils = null;

	private MovieRepoImpl() throws IOException {
//		dbUtils = DBUtils.getInstance();
	}

	private static MovieRepo moviesrepository;

	public static MovieRepo getInstance() throws IOException {
		if (moviesrepository == null) {
			moviesrepository = new MovieRepoImpl();
		}
		return moviesrepository;
	}

	@Override
	public String addMovies(Movies movie) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "insert into movies"
				+ " (moviesid,moviename,agelimit,cast,genre,length,trailer,releasedate,language)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getCast());
			preparedStatement.setString(5, movie.getGenre());
			preparedStatement.setDouble(6, movie.getLength());
			preparedStatement.setString(7, movie.getTrailer());		
			preparedStatement.setString(8, movie.getReleaseDate());
			preparedStatement.setString(9, movie.getLanguage());
			

//					returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				connection.rollback();
				return "failed";
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
			return "Failed";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String modifyMovies(String id, Movies movie) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "update movies set moviename=?,agelimit=?,"
				+ "cast=?,genre=?, length=?,trailer=?," + "releasedate=?,language=? where moviesid=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setInt(3, movie.getAgeLimit());
			preparedStatement.setString(4, movie.getCast());
			preparedStatement.setString(5, movie.getGenre());
			preparedStatement.setDouble(6, movie.getLength());
			preparedStatement.setString(7, movie.getTrailer());		
			preparedStatement.setString(8, movie.getReleaseDate());
			preparedStatement.setString(9, movie.getLanguage());
			
//			returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				connection.rollback();
				return "failed";
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
			return "Failed";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public Optional<Movies> getMovieById(String id)
			throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where moviesid=?";

		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Movies movie = new Movies();
				movie.setId(resultSet.getString("moviesid"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setReleaseDate(resultSet.getString("releasedate"));
				movie.setAgeLimit(resultSet.getInt("agelimit"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setCast(resultSet.getString("cast"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

	@Override
	public List<Movies> getAllMovies() throws InvalidNameException, InvalidIdLengthException, NameNotFoundException {
		Optional<List<Movies>> optional = this.getAllMoviesDetails();
		if (optional.isEmpty()) {
			return null;
		} else {
			List<Movies> list = optional.get();
			return list;
		}
	}

	@Override
	public Optional<List<Movies>> getAllMoviesDetails()
			throws InvalidIdLengthException, InvalidNameException, NameNotFoundException

	{
		List<Movies> movies = new ArrayList<Movies>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from movies";

		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Movies movie = new Movies();
				movie.setId(resultSet.getString("moviesid"));
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setReleaseDate(resultSet.getString("releasedate"));
				movie.setAgeLimit(resultSet.getInt("agelimit"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setCast(resultSet.getString("cast"));
				movies.add(movie);
			}
			return Optional.ofNullable(movies);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

	@Override
	public String deleteMovies(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteStatement = "delete from movies where moviesid=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
//			returns number of row affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
				return "failed";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

}