package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	//bring the userRepository object
	//using getInstance method
	//are we expecting that repo object we should get it from spring?
	
	private UserRepository userRepository;
//	private UserServiceImpl() throws IOException {
//		// TODO Auto-generated constructor stub
//		userRepository  =  UserRepositoryImpl.getInstance();
//	}
//	
//	private static UserService service;
//	
//	public static UserService getInstance() throws IOException {
//		
//		if(service==null) {
//			service = new UserServiceImpl();
//		}
//		
//		return service;
//	}
	
	//UserRepository userRepository ;
	@Override
	public String addUser(Register register) throws SQLException {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.userRepository.updateUser(id, register);
	}

	@Override
	public Optional<List<Register>> getUserById(String id) throws IdNotFoundException, InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidIdLengthException, SQLException {
		// TODO Auto-generated method stub
		return this.userRepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SQLException {
		// TODO Auto-generated method stub
		return this.userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return this.userRepository.deleteUserById(id);
	}
	
	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getAllUserDetails();
	}

	@Override
	public Optional<List<Register>> getUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}