package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import java.util.Iterator;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		Register register = new Register();
//		register.setFirstName("Nikhil");
//		register.setLastName("Pathak");
//		register.setId("nik12345");
//		register.setEmail("nik@gmail.com");
//		register.setPassword("12345");
//		
//		System.out.println(register);
		
		// same as line 16
//		System.out.println(register.toString());
		
		//accessing email from register class / dto package 
//		System.out.println(register.getEmail());
		
		
//		Class Login
//		Login login = new Login();

//		Class UserService	
		try {
			register.setFirstName("nikhil");
			register.setLastName("pathak");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		register.setEmail("nik@gmail.com");
		register.setPassword("nik1234");
		try {
			register.setId("ab00001");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(register);
		// whenever you will print the reference then it 
		// will call toString() method.
		
		System.out.println(register.toString());
	
		System.out.println(register.getEmail());
		
		// can u create the login object?
		// then can u print the login detials?
		
		UserService service = UserServiceImpl.getInstance();
		
		for(int i=1;i<=20;i++) {
		
			Register register2 = new Register();
			try {
				register2.setId("ab0000"+i);
				register2.setFirstName("nikhil"+i);
				register2.setLastName("pathak"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			catch (Throwable e) {
				// TODO: handle exception
			}	
			
			register2.setPassword("nikhil");
			String result = service.addUser(register2);
			System.out.println(result);
		}
		
	
		
		
		// userservice object
		// main is consuming the service ?
		
		Optional<Register> optional = service.getUserById("ab00001");
		
		if(optional.isPresent()) {
			
			System.out.println("getUserById"+optional.get());
		}
		else {
			System.out.println("id not found/available");
		}
		
//		delete user by Id
		System.out.println(service.deleteUserById("nik1234"));
//	get all users
		for (Register register3 : service.getAllUsers()) {
			if(register3!=null) System.out.println(register3);
		};
	}

}