package com.zee.zee5app.repository;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Register;
// repo. objects are used to call only repo methods 
// can we do this using 1 object?
@Repository
public class UserRepository2 {
	
	private Register[] registers = new Register[10];
	private static int count=-1;
	public UserRepository2() {
		// TODO Auto-generated constructor stub
	}
	
	// to return all the user details 
	
	public Register[] getUsers() {
		return registers;
	}
	
	// delete user is an assignemnt for u
	// 20 user on 5th ind 
	// from 5th index
	public String deleteUser(String id) {
		return null;
	}
	// update user is an assignment for u.
	
	public String udateUser(String id , Register register) {
		return null;
	}
	// this method should return the User Details based on the id
	public Register getUserById(String id) {
		
		// do we need to traverse the array?
		
		for (Register register : registers) {
			if(register!=null && register.getId().equals(id) ) {
				return register;
			}
		}
		
		return null;
		
	}
	
	// add a new user
	public String addUser(Register register) {
		
		//registers.length ====> it will give us the availability
		
		if(count==registers.length-1) {
			// array is full or we should go for dynamically growing the 
			// size of array.
			Register temp[] = new Register[registers.length*2];
			
			// do we need to copy the contents from old to new? Yes
			
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers= temp;
			registers[++count] = register;
			
			
			return "success";
			
		}
		registers[++count] = register;
		return "success";
		// 
		
				
		
	}
	
//	private static UserRepository2 userRepository;
//	public static UserRepository2 getInstance() {
//		
//		if(userRepository==null)
//			userRepository = new UserRepository2();
//		return userRepository;
//		
//	}

}