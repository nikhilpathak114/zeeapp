package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Register;

public class UserRepository {
	
	private Register[] registers = new Register[10];
	private static int count =-1;
	private UserRepository() {
		
	}
	
	public Register[] getUsers() {
		return registers;
	}
	
	//delete user function we have to create(Assignment)
	//20 user on 5th index
	//from 5th index
	public String deleteUsers(String id, Register register) {
		for (Register delRegister : registers) {
			if(delRegister != null) {
				if(delRegister.getId().equals(id)) {
					continue;
				}
				Register temp1[] = new Register[registers.length];
				
				//we need to copy contents from old to new
				System.arraycopy(registers, 0, temp1, 0, registers.length);
				registers = temp1;
				registers[++count] = register;
				
				
				return "success";
			}
		}
		return null;
	}
	
	//update user function we have to create(Assignment)
	public String updateUsers(String id, Register register) {
		for(Register currRegister : registers) {
			if(currRegister != null) {
				if(currRegister.getId().equals(id)) {
					currRegister.setEmail(register.getEmail());
					currRegister.setFirstName(register.getFirstName());
					currRegister.setLastName(register.getLastName());
					currRegister.setPassword(register.getPassword());
					return "updated";
				}
			}
		}
		
		return null;
	}
	
	//this method should return the user details based on the id
	public Register getUserById(String id) {
		
		//we need to traverse the array
		
		for (Register register : registers) {
			if(register != null && register.getId().equals(id)) {
				return register;
			}
		}
		
		return null;
	}
	
	//adduser
	public String addUser(Register register) {
		//registers.length ====> it will give us availability
		
		if(count == registers.length-1) {
			
			//array is full or we should go for dynamically growing the size of array
			Register temp[] = new Register[registers.length*2];
			
			//we need to copy contents from old to new
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers = temp;
			registers[++count] = register;
			
			
			return "success";
		}
		registers[++count] = register;
		return "success";
	}
	
	private static UserRepository userRepository;
	public static UserRepository getInstance() {
		if(userRepository == null)
			userRepository = new UserRepository();
		return userRepository;
	}
}
