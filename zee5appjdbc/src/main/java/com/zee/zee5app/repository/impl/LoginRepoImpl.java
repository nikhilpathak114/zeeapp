package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
@Component
@Repository
public class LoginRepoImpl implements LoginRepo {
	
	@Autowired
	DataSource dataSource;
	@Autowired
	private LoginRepoImpl loginRepository;

	private LoginRepoImpl() throws IOException {
//		dbutils = DBUtils.getInstance();
	}

//	static LoginRepoImpl getInstance() throws IOException {
//		if (loginRepository == null)
//			loginRepository = new LoginRepoImpl();
//		return loginRepository;
//	}

	@Override
	public String addCredentials(Login login) throws SQLException {
		Connection connection = dataSource.getConnection();
		String insertQuery = "insert into login (username, password, regid,role)" + "values(?,?,?,?)";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
			prepStatement.setString(1, login.getUserName());
			prepStatement.setString(2, login.getPassword());
			prepStatement.setString(3, login.getRegid());
			prepStatement.setString(4, login.getRole().toString());
			int result = prepStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String deleteCredentials(String userName) throws SQLException {
		Connection connection = dataSource.getConnection();
		String delQuery = "DELETE FROM login where username=?";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(delQuery);
			prepStatement.setString(1, userName);
			int result = prepStatement.executeUpdate();
			if (result > 0)
				//delete this user 
				return "success";
			else
				return "fail";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String changePassword(String userName, String password) {

		return null;
	}
	
	@Override
	public String changeRole(String username, ROLE role) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection;
		PreparedStatement preparedStatement ;
		String updateStatement = "UPDATE login SET role = ? WHERE username = ?";
		connection = dataSource.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, username);
			
			int result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteCredentials(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

}
