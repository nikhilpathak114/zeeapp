package com.zee.zee5app.repository.impl;

import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
	
	private TreeSet<Register> set = new TreeSet<>();
	// when u will use DC for AL then by default it will hold 10 elements
	// of type Register.
	
	//private static int count=-1;
	
	private UserRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	
	public static UserRepository getInstance() {
		if(repository==null) {
			repository = new UserRepositoryImpl();
		}
		return repository;
	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(register);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override//Assignment
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
		// do we need to traverse the AL?
		// yes 
		Register register2 = null;
		for (Register register : set) {
			if(register.getId().equals(id)) {
				register2 = register;
			}
		}
		
		return Optional.ofNullable(Optional.of(register2).orElseThrow(()->new IdNotFoundException("exception id not found")));
		// if register2 is holding null it will act like an empty
		// if register2 is holding object it will act like of
		
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		
		Register register[] = new Register[set.size()];
		
		return set.toArray(register);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Register> optional = this.getUserById(id);
		if(optional.isPresent()) {
			
			boolean result = set.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else {
				return "fail";
			}
		}
		return "fail";
		
	}
	
	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
		//descending 0rder
		
		return new ArrayList<>(set.descendingSet());
		//we are returning all the details but now we need to return it in terms of sorted order 
		//Collections.sort(set);
		//return set;
	}
	
}