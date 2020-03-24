package com.techelevator.npgeek.model;

import java.util.List;

public interface WeatherDAO {
	
	/********************************
	 * Get The Weather By Park Code *
	 * @param parkCode				*
	 * @return						*
	 *******************************/
	
	public List<Weather> getWeatherByParkCode(String parkCode);
	
}