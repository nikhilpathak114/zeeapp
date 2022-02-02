package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor

@Entity
@Table(name="subscription")

public class Subscription implements Comparable<Subscription>{
	
	@Id
	@NotBlank
	private String id;
	@NotBlank
	private String type;
	
	@NotNull
    private String dateOfPurchase;
    private String paymentMode;
    
    @Setter(value = AccessLevel.NONE)
    @NotNull
    private int amount;
    
    @NotBlank
    private String status;
    @NotBlank
    private String autoRenewal;
    
    @NotNull
    private String expiryDate;

    @NotBlank
    private String regid;
    
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return 0;
	}

}