package com.zee.zee5app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
@Repository
public interface UserService {

	public String addUser(Register register) throws SQLException, AlreadyExistsException;
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidIdLengthException, SQLException;
	public String deleteUserById(String id) throws IdNotFoundException, SQLException, InvalidPasswordException, InvalidEmailException;
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException, SQLException;
	public Optional<List<Register>> getAllUsersDetails() throws javax.naming.InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, InvalidIdLengthException;
}