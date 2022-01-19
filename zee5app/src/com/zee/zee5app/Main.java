package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Register register = new Register();
		Login login = new Login();
		//Register: class Name
		//register: reference which will refer your object
		//new: is used to create the object
		//Register: default Constructor
		
		register.setFirstName("Nikhil");
		register.setLastName("Pathak");
		register.setEmail("nik@gmail.com");
		register.setPassword("11234");
		login.setUserName("Nikhilpat11234");
		login.setPassword("11234");
		
		System.out.println(register);
		System.out.println(register.toString());
		System.out.println(register.getEmail());
		
		System.out.println(login);
		
		UserService service = UserService.getInstance();
		
		for(int i=1;i<=20;i++) {
			
			Register register2 = new Register();
			register2.setId("ab00"+i);
			register2.setFirstName("Nikhil"+i);
			register2.setLastName("Pathak"+i);
			register2.setPassword("nikh");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		
		//userservice object
		//main is consuming the service ?
		
		Register register2 = service.getUserById("ab1");
		System.out.println(register2!=null);
		
		for (Register register3 : service.getUsers()) {
			if(register3 != null)
				System.out.println(register3);
		}
	}

}
