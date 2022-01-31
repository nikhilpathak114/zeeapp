package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.repository.impl.LoginRepoImpl;
import com.zee.zee5app.service.LoginServ;

@Service
public class LoginServImpl implements LoginServ {

	LoginRepo repository ;
//    private LoginServImpl() throws IOException{
//        repository = LoginRepoImpl.getInstance();
//
//    }
    
	private static LoginServ service;

//	public static LoginServ getInstance() throws IOException{
//		if (service == null) {
//			service = new LoginServImpl();
//		}
//		return service;
//	}
	
	public String addCredentials(Login login) throws SQLException{
		return this.repository.addCredentials(login);
	}

	public String deleteCredentials(String userName) {
		return null;
	}

	public String changePassword(String userName, String password) {
		return null;
	}
}
