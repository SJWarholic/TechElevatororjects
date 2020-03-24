package com.techelevator.npgeek.model;

public class Weather {
	
	private String parkCode;
	private int dayNum;
	private int low;
	private int high;
	private String forecast;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getDayNum() {
		return dayNum;
	}
	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	public String getAdvisory() {
		
		String result = "";
		switch(this.getForecast()) {
		case "snow": result="Better Pack Some Snowshoes! ";
		break;
		case "rain": result="Pack Your Rain-gear! ";
		break;
		case "thunderstorms": result="Seek Shelter And Avoid Hiking On Exposed Ridges And Cliffs! ";
		break;
		case "sun": result="Pack Some Sunblock! ";
		break;
		}
	
		int high = this.getHigh();
		int low = this.getLow();
		
		if (high > 75) {
			result += "Don't Forget To Bring An Extra Gallon Of Water! ";
		}
		if (low < 20) {
			result += "It's Damn Cold! Don't Catch Hypothermia! ";
		}
		if((high - low) > 20) {
			result += "Wear Those Breathable Layers!";
		}
		
		return result;
	}
	

}