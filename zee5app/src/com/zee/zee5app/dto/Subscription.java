package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Subscription {

	private String id;
	private String type;
	private String status;
	private String packCountry;
	private String paymentMode;
	private String autoRenewal;
	private String purchaseDate;
	private String expiryDate;
	
}
