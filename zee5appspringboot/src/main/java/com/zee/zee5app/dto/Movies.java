package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "movieName")})
public class Movies implements Comparable<Movies>{

	@Id
	@Column(name="moviesid")
	private String id;
	@NotBlank
	private String movieName;
	@Min(value=60)
	private int length;
	@NotBlank
	private String genre;
	@NotNull
	private String releaseDate;
	
//	@Lob
//	private byte[] trailer;
	private String trailer;
	
	@NotBlank
	private String cast;
	@Max(value=70)
	private int ageLimit;
	@NotBlank
	private String language;

	@Override
	public int compareTo(Movies o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
}