package com.techelevator.npgeek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	@NotBlank(message="This is a required field!")
	@Size(min=4, max= 20, message="User Name must be between 4 and 20 characters!")
	private String userName;
	
	@NotBlank(message="This is a required field!")
	private long userID;
	
	@Size(min=8, max= 20, message="Password must be between 8 and 20 characters!")
	@NotBlank(message="This is a required field!")
	private String password;
	
	@Size(min=5, max= 20, message="Password Hint must be between 5 and 30 characters!")
	@NotBlank(message="This is a required field!")
	private String passwordHint;
	
	@NotBlank(message="This is a required field!")
	@Email(message="A valid Email is required!")
	private String email;

	public String getUserName() {
		return userName;
	
	
	
	
	
	
	
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
