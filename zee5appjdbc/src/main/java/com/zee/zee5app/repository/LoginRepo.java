package com.zee.zee5app.repository;

import java.sql.SQLException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginRepo {

	public String addCredentials(Login login) throws SQLException;
	public String deleteCredentials(Login login);
	public String changePassword(String userName, String password);
	public String changeRole(String username, ROLE role) throws SQLException;
	public String deleteCredentials(String userName) throws SQLException;
}
