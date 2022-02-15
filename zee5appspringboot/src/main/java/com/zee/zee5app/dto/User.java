package com.zee.zee5app.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

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
@Table(name = "reg",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "email")})
public class User implements Comparable<User>{
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max=20)
	@NotBlank
	private String username;
	
	@Size(max=50)
	@NotBlank
	private String firstName;
	@Size(max=50)
	@NotBlank
	private String lastName;
	
	@Size(max=50)
	@Email
	private String email;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
//	@NotNull
//	private BigInteger contactnumber;

	//here Main is caller for this
	
	@Override
	public int compareTo(User o) {
		 //TODO Auto-generated method stub
		//ascending
		return this.id.compareTo(o.getId());
		
		//descending order
		//return o.id.compareTo(this.getId())
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	//3rd  table
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="regid"),
	inverseJoinColumns = @JoinColumn(name="roleId"))//registered user(regid) and role(roleid)
	private Set<Role> roles = new HashSet<Role>();
	
	public User(String username, String email, String password,String firstName, String lastName) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Subscription subscription;
	
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Login login;
	
}