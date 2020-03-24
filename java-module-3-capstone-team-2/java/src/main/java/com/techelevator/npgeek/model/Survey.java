package com.techelevator.npgeek.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
		
		private long surveyId;
		private String parkCode;
		@NotBlank(message="This Field Cannot Be Blank!")
		@Email(message="Must Be A Valid Email Address!")
		private String email;
		private String state;
		private String activityLevel;
		
		public long getSurveyId() {
			return surveyId; 
		}
		public void setSurveyId(long surveyId) {
			this.surveyId = surveyId;
		}
		public String getParkCode() {
			return parkCode;
		}
		public void setParkCode(String parkCode) {
			this.parkCode = parkCode;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getActivityLevel() {
			return activityLevel;
		}
		public void setActivityLevel(String activityLevel) {
			this.activityLevel = activityLevel;
		}
		
		
	
}
