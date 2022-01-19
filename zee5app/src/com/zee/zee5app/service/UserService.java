package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
//service objects are used to call the services inside the main method
//we can use it with one object
//solution singleton design pattern
//one ==> to get only one object for the specific type.

public class UserService {
	
	private UserRepository repository = UserRepository.getInstance();
	//service is consuming the repository
	
	private UserService(){
		
	}
	//if we want to create that single object then we have to create it
	//inside the same class'
	//and we have to share ref with others
	//to do the same we have to declare a method.
	private static UserService service = null;
	// this would be a static ref
	//only one copy
	
	public static UserService getInstance() {
		//it becomes object independent??
		// static will make it independent on the object for execution.
		
		// static method will only acces static ref
		if(service == null)
			service = new UserService();
		return service;
		
	}
	
	public String addUser(Register register) {
		//we need to consume the adduser method from repo.
		return this.repository.addUser(register);
	}
	
	public Register getUserById(String id) {
		return this.repository.getUserById(id);
	}
	
	public Register[] getUsers() {
		return repository.getUsers();
	}
	
	public Register getupdateUsers(String id, Register register) {
		return repository.getupdateUser(id, register);
	}
	
	public Register getdeleteUsers(String id, Register register) {
		return repository.getdeleteUser(id, register);
	}
}
