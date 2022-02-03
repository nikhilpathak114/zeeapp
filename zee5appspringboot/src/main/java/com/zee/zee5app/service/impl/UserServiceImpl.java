package com.zee.zee5app.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
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
	@Autowired
	private LoginRepo loginrepository;

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public String addUser(Register register) throws AlreadyExistsException, SQLException{
		// TODO Auto-generated method stub
		
		if(userrepository.existsByEmail(register.getEmail()) || userrepository.existsByContactnumber(register.getContactnumber()) ) {
			throw new AlreadyExistsException("This record already exist.");
		}
		Register register2 = userrepository.save(register);
			if(register2!=null) {
				if(loginrepository.existsByUserName(register.getEmail())){
					throw new AlreadyExistsException("This record already exist.");
				}
				Login login = new Login();
				login.setRegid(register.getId());
				login.setUserName(register.getEmail());
				login.setPassword(register.getPassword());
				String result = loginservice.addCredentials(login);
				if(result.equals("Success")) {
					return "user added in login and register successfully";
				}
				else{
					return "Failed";
				}
			}
			else {
				return "Failed";
			}
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