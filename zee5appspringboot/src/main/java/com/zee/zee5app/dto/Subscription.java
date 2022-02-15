package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subscription")

public class Subscription implements Comparable<Subscription>{
	
	@Id
	@NotBlank
	private String subid;
	@NotBlank
	private String type;
	
	@NotNull
    private String dateOfPurchase;
    private String paymentMode;
    
    @NotNull
    private int amount;
    
    @NotBlank
    private String status;
    @NotBlank
    private String autoRenewal;
    
    @NotNull
    private String expiryDate;
    
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.subid.compareTo(o.getSubid());
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "userId")
	private User user;

}