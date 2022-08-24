package com.cts.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Model class for user credentials
 * 
 * @author Ujjwal Sinha
 * @author 857152
 *
 */

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_credentials")
public class User {
	@Id
	private String username;
	@Column(nullable = false)
	private String password;
	@Column
	private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
//	public User() {
//		
//	}
//	public User(String username, String password, String role) {
//		
//		this.username = username;
//		this.password = password;
//		this.role = role;
//	}
	
}
