package com.zee.zee5app.repository;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginRepo extends JpaRepository<Login, String> {
	
}
