package com.techelevator.npgeek.model;

import java.util.List;

public interface ParkDAO {
	
	/*****************
	 * Get All Parks *
	 * @return		 *
	 ****************/
	
	public List<Park> getAllParks();
	
	
	/*****************************
	 * Get The Park By Park Code *
	 * @param parkCode			 *
	 * @return					 *
	 ****************************/
	
	public Park getParkByCode(String parkCode);

}