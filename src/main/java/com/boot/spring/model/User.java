package com.boot.spring.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.boot.spring.utils.CryptUtil;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email; 
	
	@Column(name = "birthday")
	private String birthday; 
	
	@Column(name = "password")
	private String password;
	
	private String role;
	
	@Column(name = "analyst_id")
	private String analystId;
	
	@Column(name = "manager_id")
	private String managerId;

	// Getter and Setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getAnalystId() {
		return analystId;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setAnalystId(String analystId) {
		this.analystId = analystId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	// users helpers
	public static String idGenerator() {
		return UUID.randomUUID().toString();
	}
	
	public boolean isValidPassword(String password) {
		return CryptUtil.verify(password, this.password);
	}
	
}
