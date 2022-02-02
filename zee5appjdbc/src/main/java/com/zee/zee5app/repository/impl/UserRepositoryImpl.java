package com.zee.zee5app.repository.impl;

import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.mysql.cj.protocol.Resultset;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

@Component
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired // it will bring ur already created objects either by using name/type;
	DataSource dataSource;
	@Autowired
	PasswordUtils passwordUtils;
	private LoginRepo loginRepository ;
	
	public UserRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
//		dbutils = DBUtils.getInstance();
		//loginRepository = LoginRepoImpl.getInstance();
	}

	@Override
	public String addUser(Register register) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertStatement = 
				"insert into register"
				+ " (regid,firstname,lastname,email,contactnumber,password)"
				+ " values(?,?,?,?,?,?)";
		connection = dataSource.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactnumber());
			String salt = passwordUtils.getSalt(30);
			String encryptedPassword = passwordUtils.generateSecurePassword(register.getPassword(),salt);
			preparedStatement.setString(6, encryptedPassword);
			
			
//			At the same time username,password, regid we have to store
//			in the login table as well. Since these are required fields
//			for login.
			
			
			
//			returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				Login login = new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegid(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepository.addCredentials(login);
				if(res.equals("Success")) {			
					return "Success";
				}
				else {
					connection.rollback();
					return "Failed";
				}
				
			}
			else {
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
		}
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Register>> getUserById(String id) throws IdNotFoundException, InvalidEmailException,
			InvalidPasswordException, InvalidNameException, InvalidIdLengthException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Register> arrayList = new ArrayList<>();
		String selectStatement = "select * from register whre registerId=?";

		connection = dataSource.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				// next method is used to traverse the RS
				// initially RS will be places above the 1st rec.
				// when u will call 1st time rs will retrieve the first record &
				// it will refer the 2nd one
				Register register = new Register();
				register.setId(resultset.getString("regid"));
				register.setFirstName(resultset.getString("firstname"));
				register.setLastName(resultset.getString("lastname"));
				register.setEmail(resultset.getString("email"));
				register.setPassword(resultset.getString("password"));
				register.setContactnumber(resultset.getBigDecimal("contactnumber"));
				arrayList.add(register);

			}

			return Optional.ofNullable(null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SQLException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional = getAllUserDetails();
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Register> list = optional.get();
			Register[] registers = new Register[list.size()];
			return list.toArray(registers);
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SQLException {
		// TODO Auto-generated method stub
		List<Register> registers = new ArrayList<Register>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;
		
		String selectStatement = 
				"select * from register";
		
		connection = dataSource.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Register register = new Register();
				register.setId(resultSet.getString("regid"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactnumber(resultSet.getBigDecimal("contactnumber"));
				registers.add(register);
		}
			return Optional.ofNullable(registers);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		// add the user details to the table.
		String deleteStatement = "delete from register";
		// we will concatenate the values in values spec
		// here we will provide the values againt placeholder
		connection = dataSource.getConnection();

		try {
			preparedstatement = connection.prepareStatement(deleteStatement);

			preparedstatement.setString(1, id);
			int result = preparedstatement.executeUpdate();

			if (result > 0) {
				//delete this user
				return "Success";
			} else {
				return "fail";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

}