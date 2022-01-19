package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Register {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String aadharCardNumber;
	
	public Register() {
		//EDC
		//any kind of customization during the initialization of object
		//then its better to introduce EDC or PC or both as per the need.
		
		System.out.println("Hello");
	}
	
	//private stuff can only accessible inside the class.
	
	//setter is used to set the value for a particular field
	//getter is used to get/return the value of a specific field

}
