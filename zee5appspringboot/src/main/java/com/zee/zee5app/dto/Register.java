package com.zee.zee5app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import java.lang.*;
import java.math.BigDecimal;
import java.math.BigInteger;

//write @Data and then press ctrl+space then enter to get the lombok
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

//we use this method to override instead of other one used below coz when we change anything later, it can handle on its own
@EqualsAndHashCode
@ToString

//ORM mapping purpose
@Entity //entity class is used for ORM
//we can customize the table name
@Table(name = "reg")

public class Register implements Comparable<Register>{
//public class Register {
	//add contact number field
//	public Register(String id, String firstName, String lastName, String email, BigDecimal contactnumber, String password) 
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		super();
// 		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//		this.setContactnumber(contactnumber);
//	}
//	
//	public Register(String id, String firstName, String lastName, String email,String password) 
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		super();
// 		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//	}
//	
	@Id //it will consider this column as PK
	@Column(name ="regid")
	private String id;
	
	@Size(max=50)
	@NotBlank
	private String firstName;
	private String lastName;
	
	@Size(max=50)
	@Email
	private String email;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	
	private String contactnumber;

	//here Main is caller for this
	
	@Override
	public int compareTo(Register o) {
		 //TODO Auto-generated method stub
		//ascending
		return this.id.compareTo(o.getId());
		
		//descending order
		//return o.id.compareTo(this.getId())
	}
	
	

//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, password);
//	}
//
//	@Override
//	we override to know how to handle it behind the scenes
//	public boolean equals(Object obj) {
//		//this are the 5 points under equals contract
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Register other = (Register) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(password, other.password);
//	}
	
	//private stuff will be accessible only within the class
	
	//setter function : is used to set the value for a particular field
	//getter function : to get/return the value of a specific field
	
}