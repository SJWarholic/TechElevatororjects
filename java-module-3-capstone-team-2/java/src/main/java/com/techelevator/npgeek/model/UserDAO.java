package com.techelevator.npgeek.model;

import java.util.List;


public interface UserDAO {

	 public User saveUser(String userName, String password, String hint, String email);

	 
	 public User getPasswordHint(String userName);
	 
	 
	 public String changePassword(String userName, String password);


	 public User getValidUserWithPassword(String userName, String password);
	 
	 
}
