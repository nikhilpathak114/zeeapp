package com.zee.zee5app.dto;

import java.net.URL;
import java.lang.*;
import javax.naming.NameNotFoundException;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "seriesName")})
public class Series implements Comparable<Series> {

	
	@Id
	@Column(name="seriesid")
	private String id;
	@NotBlank
	private String seriesName;
	
	@NotBlank
	private String genre;
	@NotNull
	private String releaseDate;
	
	@NotBlank
	private String trailer;
	@NotBlank
	private String Cast;
	
	@Max(value=70)
	private int ageLimit;
	@NotBlank
	private String language;
	@Min(value=1)
	private int noofepisodes;


	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	@OneToMany(mappedBy = "series",cascade=CascadeType.ALL)
	private List<Episodes> episodes = new ArrayList<>(); 
}