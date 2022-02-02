package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "episodes")
public class Episodes implements Comparable<Episodes> {
	
	@Id
	@Column(name = "epiId")
	private String id;
	@NotBlank
	private String serId;
	@NotBlank
	private String name;
	@NotNull
	private double length;
	@NotBlank
	private String location;
	private String trailer;

	@Override
	public int compareTo(Episodes o) {
		// TODO Auto-generated method stub
		return 0;
	}

}