package com.example.Bankmangement.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
  public User() {
	  
  }
	public User(long id, String name, String username, String password, String address, String state, String country,
			String email, String pan, long contactno, Date dob, String accountType, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.pan = pan;
		this.contactno = contactno;
		this.dob = dob;
		this.accountType = accountType;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@Column(nullable=false ,unique=true)
	private String username;
	private String password;
	private String address;
	private String state;
	private String country;
	private String email;
    private String pan;
	private long contactno;
	private Date dob;
	private String accountType;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="user_roles",
	joinColumns= @JoinColumn(name="user_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="role_id" , referencedColumnName="id"))
	private Set<Role> roles;
	
	
}
