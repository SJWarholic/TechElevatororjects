package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDAO {
	
	/************************************
	 * Save The Survey To DataBase      *
	 * @param parkCode                  *
	 * @param email                     *
	 * @param state                     *
	 * @param activityLevel             *
	 ***********************************/
	
	public void saveSurvey(String parkCode, String email, String state, String activityLevel);
	
	
	/******************************
	 * Get All The Survey Results *
	 * @return					  *
	 *****************************/
	
	public List<SurveyResults> getAllSurveyResults();

	
	/*****************
	 * Save Survey   *
	 * @param survey *
	 ****************/
	
	public void save(Survey survey);
	


}

	
