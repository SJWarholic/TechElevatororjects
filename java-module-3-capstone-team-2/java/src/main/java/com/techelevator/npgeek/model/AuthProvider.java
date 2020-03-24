package com.techelevator.npgeek.model;

public interface AuthProvider {

	boolean isLoggedIn();
	
	
	User getCurrentUser();
	
	
	boolean signIn(String userName, String password);
	
	
	void logOff();
	
	
	boolean changePassword(String existingPassword, String newPassword);

	
	void register(String userName, String password, String hint, String email);


}
