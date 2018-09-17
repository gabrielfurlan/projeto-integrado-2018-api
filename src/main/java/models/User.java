package models;

import java.sql.Date;
import java.util.UUID;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users")
public class User {
	
	@Id
	private String id;
	
	@NotBlank
	private String email;
	
	private String password;
	
	@Column(name = "first_name")
	@NotBlank
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	private String lastName;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@NotBlank
	private String role;

	@Column(name = "analyst_id")
	@NotBlank
	private String analystId;
	
	@Column(name = "manager_id")
	private String managerId;
	
	
	// users helpers
	public static String idGenerator() {
		return UUID.randomUUID().toString();
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAnalystId() {
		return analystId;
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
}
