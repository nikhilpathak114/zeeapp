package com.zee.zee5app.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;

@Component
@Repository
public class LoginRepo2 {
	
	public Login[] login = new Login[10];
	private static int count = -1;
	
	public String addCredentials(Login login) {
			return null;	
	}
	
	public String deleteCredentials(String userName) {
		return null;
	}
	
	public String changePassword(String userName, String password) {
		return null;
	}
}
