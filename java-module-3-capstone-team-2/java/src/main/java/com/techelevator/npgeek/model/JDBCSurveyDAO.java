package com.techelevator.npgeek.model;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

	@Component
	public class JDBCSurveyDAO implements SurveyDAO{
		
		private JdbcTemplate jdbcTemplate;
		
		/**********************
		 * SurveyDAO AUTOWIRE *
		 *********************/
		
		@Autowired
		public JDBCSurveyDAO(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		/**************************************
		 * Save The User's Survey To DataBase *
		 *************************************/

		@Override
		public void saveSurvey(String parkCode, String email, String state, String activityLevel) {
			long	 surveyId = getNextSurveyId();
			String insertIntoSurvey = "INSERT INTO survey_result VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(insertIntoSurvey, surveyId, parkCode, email, state, activityLevel);
		}
		
		/**************************************
		 * Get All The Survey Results (List)  *
		 *************************************/

		@Override
		public List<SurveyResults> getAllSurveyResults() {
			List<SurveyResults> surveyResultList = new ArrayList<SurveyResults>();
			String getAllSurveyResults = "SELECT COUNT(park.parkcode) AS surveycount, park.parkcode, parkname" 
									   + " FROM survey_result" 
					                   + " JOIN park ON park.parkcode = survey_result.parkcode"
					                   + " GROUP BY park.parkcode ORDER BY surveycount desc;";
			SurveyResults theSurveyResult = new SurveyResults();
			SqlRowSet results = jdbcTemplate.queryForRowSet(getAllSurveyResults);
			while (results.next()) {
				theSurveyResult = mapRowToSurveyResults(results);
				surveyResultList.add(theSurveyResult);
				
			}
			return surveyResultList;
		}
		
		/**************************
		 * Get The Next Survey ID *
		 *************************/
		
		public long getNextSurveyId() {
			SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_surveyid')");
			if (nextIdResult.next()) {
				return nextIdResult.getLong(1);
			}
			else {
				throw new RuntimeException("Something went wrong with survey sequence");
			}
		}
		
		/*****************************
		 * Map Row To Survey Results *
		 * @param results			 *
		 * @return					 *
		 ****************************/
		
		private SurveyResults mapRowToSurveyResults(SqlRowSet results) {
			SurveyResults theSurveyResult = new SurveyResults();
			theSurveyResult.setParkCode(results.getString("parkcode"));
			theSurveyResult.setParkName(results.getString("parkname"));
			theSurveyResult.setSurveySum(results.getInt("surveycount"));
			return theSurveyResult;
		}

		/*******************
		 * Save The Survey *
		 ******************/

		@Override
		public void save(Survey survey) {
			long	 surveyId = getNextSurveyId();
			String insertIntoSurvey = "INSERT INTO survey_result VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(insertIntoSurvey, surveyId, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
		}
		
		
}
