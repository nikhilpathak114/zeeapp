package com.zee.zee5app.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="login")
public class Login {

	@Id
	@Column(name="userName")
	@Email
	private String userName;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotBlank
	private String regid;
	
}
