package com.zee.zee5app.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.exception.IdNotFoundException;

@Repository
public interface RoleServ{

	public String addRole(Role role);
	public String deleteRole(int roleId) throws IdNotFoundException;
	
}
