package com.zee.zee5app.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.exception.IdNotFoundException;

@Service

public interface LoginServ {
	
	public String addCredentials(Login login) throws SQLException;
	public String deleteCredentials(String id) throws IdNotFoundException;
	public String changePassword(String username,String password);
	public String changeRole(String username,ROLE role);
}
