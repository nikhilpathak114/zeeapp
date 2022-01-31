package com.zee.zee5app.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface UserRepository {
	
	public String addUser(Register register) throws SQLException;
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<List<Register>> getUserById(String id) throws IdNotFoundException, InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidIdLengthException, SQLException;
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SQLException;
	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SQLException;
	public String deleteUserById(String id) throws IdNotFoundException, SQLException;

}

// we can't create/declare the objects
// we can declare only references
// when we will refer the objects whose class is implementing the interface 
// then that object will behave like an interface i.e. 
// we can get only access for the interface ovrriden methods.