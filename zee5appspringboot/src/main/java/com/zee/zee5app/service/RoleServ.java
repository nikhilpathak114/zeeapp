package com.zee.zee5app.service;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.exception.IdNotFoundException;

public interface RoleServ{

	public String addRole(Role role);
	public String deleteRole(int roleId) throws IdNotFoundException;
	
}
