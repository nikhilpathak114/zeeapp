package com.zee.zee5app.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginServ;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userrepository ;
	@Autowired
	private LoginServ loginservice;

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String addUser(Register register) throws SQLException {
		// TODO Auto-generated method stub
		Register register2 = userrepository.save(register);
		if(register2!=null) {
		 Login login = new Login();
		 login.setRegid(register.getId());
		 login.setUserName(register.getEmail());
		 login.setPassword(register.getPassword());
		 login.setRole(ROLE.ROLE_ADMIN);
		 loginservice.addCredentials(login);
		 return "Success";
		}
		else return "Failed";
	}


	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidPasswordException, InvalidEmailException {
		// TODO Auto-generated method stub
		
		return userrepository.findById(id);
	}


	@Override
	public String deleteUserById(String id) throws IdNotFoundException, InvalidPasswordException, InvalidEmailException {
		// TODO Auto-generated method stub
		
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				userrepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}


	@Override
	public Optional<List<Register>> getAllUsersDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userrepository.findAll());
	}


	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, com.zee.zee5app.exception.InvalidNameException,
			InvalidEmailException, InvalidPasswordException, SQLException {
		// TODO Auto-generated method stub
		List<Register> list = userrepository.findAll();
		Register[] array = new Register[list.size()];
		
		return list.toArray(array);
	}
	
}