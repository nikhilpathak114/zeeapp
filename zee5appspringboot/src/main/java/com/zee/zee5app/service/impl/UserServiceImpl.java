package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginServ;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;
	@Autowired
	private LoginServ loginservice;
	@Autowired
	private LoginRepo loginrepository;
//	@Autowired
//	private PasswordUtils passwordUtils;

	@Override
	public User updateUser(User register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(userrepository.findById(register.getId()).isEmpty()) {
			throw new IdNotFoundException("Record not found");
		}
		return userrepository.save(register);
	}
	
	@Override
	@Transactional(rollbackFor = AlreadyExistsException.class)
	public User addUser(User register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(userrepository.existsByEmail(register.getEmail())) {
			throw new AlreadyExistsException("This record already exists");
		}
		register.setPassword(register.getPassword());
		User register2 = userrepository.save(register);
		if (register2!=null) {
			Login login = new Login();
			if (loginrepository.existsByUserName(login.getUserName())) {
				throw new AlreadyExistsException("This record already exists");
			}
			Login result = loginservice.addCredentials(login);
			if (result!=null)
				return register2;
			else
				return null;
		}
		else
			return null;
	}

	@Override
	public Optional<User> getUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional = userrepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id does not exist");
		}
		return optional;
	}


	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional = this.getUserById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			userrepository.deleteById(id);
			return "Success";
		}
	}


	@Override
	public Optional<List<User>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userrepository.findAll());
	}


	@Override
	public User[] getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = userrepository.findAll();
		User[] registers = new User[list.size()];
		return list.toArray(registers);
	}
	
}