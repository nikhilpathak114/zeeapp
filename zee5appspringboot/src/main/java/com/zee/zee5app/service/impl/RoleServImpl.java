package com.zee.zee5app.service.impl;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.RoleRepo;
import com.zee.zee5app.service.RoleServ;

@Service
public class RoleServImpl implements RoleServ {

	@Autowired
	RoleRepo rolerepo;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		
		Role role2 = rolerepo.save(role);
		if(role2!=null) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String deleteRole(int roleId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		try {
			Optional<Role> optional = rolerepo.findById(roleId);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Id not found");
			}
			else {
				rolerepo.deleteById(roleId);
				return "Success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

}
