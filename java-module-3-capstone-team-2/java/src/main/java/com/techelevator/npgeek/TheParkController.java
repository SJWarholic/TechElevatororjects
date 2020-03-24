package com.techelevator.npgeek;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.npgeek.model.User;
import com.techelevator.npgeek.model.AuthProvider;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.SurveyResults;
import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.WeatherDAO;


@Controller
@SessionAttributes({"temperature", "parkCode"})
public class TheParkController {

	   /*********************
	    * ALL THE AUTOWIRES *
	    ********************/
		
		@Autowired
		ParkDAO parkDAO;
		@Autowired
		WeatherDAO weatherDAO;
		@Autowired
		SurveyDAO surveyDAO;
		
		/***************************************************
		 * Temperture Variables Used Throughout Controller *
		 **************************************************/
		
		String fahrenheit = "fahrenheit";
		String celcius = "celcius";
		private AuthProvider auth;
		
		/*************************************
		 * Display Login Page (First Page)   *
		 * @return							 *
		 ************************************/
		
		@RequestMapping(path="/", method=RequestMethod.GET)
		public String displayLoginPage() {
			return "UserLoginPage";
			
		}
		
		@RequestMapping(path = "/", method = RequestMethod.POST)
	    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes flash) {
	        if (auth.signIn(username, password)) {
	            return "redirect:/homePage";
	        } else {
	            flash.addFlashAttribute("message", "Login Invalid");
	            return "redirect:/";
	        }
	      }
		
		/*********************************************
		 * 	Root to Homepage (Display The Home Page) *						
		 * 											 *
		 * @param modelMap							 *
		 * @return									 *
		 ********************************************/
	
		@RequestMapping(path="/homePage", method=RequestMethod.GET)
		public String displayHomePage(ModelMap modelMap) {
			modelMap.addAttribute("parks", parkDAO.getAllParks());
			return "homePage";
			}
	
		
		/********************************
		 * Display The Park Detail Page *
		 * @param parkCode				*
		 * @param modelMap				*
		 * @param temperature			*
		 * @return						*
		 *******************************/
		
		@RequestMapping(path="/parkDetailPage", method=RequestMethod.GET)
		public String displayParkDetail(@RequestParam String parkCode, ModelMap modelMap, @RequestParam(value="temperature", required=false) String temperature) {
			modelMap.addAttribute("park", parkDAO.getParkByCode(parkCode));
			
			List<Weather> advisoryList = new ArrayList<Weather>();
			advisoryList = weatherDAO.getWeatherByParkCode(parkCode);
			modelMap.addAttribute("advisoryList",advisoryList);
			
			if (temperature != null) {
				modelMap.addAttribute("temperature", temperature);
			}
			modelMap.addAttribute("parkCode", parkCode);
			String userchoice = (String)modelMap.get("temperature");
			
			this.setTempFromUserChoice(userchoice, parkCode, modelMap);
			
			return "parkDetailPage";
			}
		
		/***************************
		 * Display The Survey Page *
		 * @param modelHolder	   *
		 * @param modelMap		   *
		 * @return				   *
		 **************************/
		
		@RequestMapping(path="/surveyInputPage", method=RequestMethod.GET)
		public String displaySurveyPage(Model modelHolder, ModelMap modelMap) {
			modelMap.addAttribute("parks", parkDAO.getAllParks());
			if (!modelHolder.containsAttribute("Survey")) {
				modelHolder.addAttribute("Survey", new Survey());
			}
			return "surveyInputPage";
		}
		
		/*******************************************
		 * Set the Temperture To The User's Choice *
		 * @param userchoice					   *
		 * @param parkCode						   *
		 * @param modelMap						   *
		 ******************************************/
		
		public void setTempFromUserChoice (String userchoice, String parkCode, ModelMap modelMap) {
			
			List<Weather> weatherList = new ArrayList<Weather>();
			weatherList = weatherDAO.getWeatherByParkCode(parkCode);
			
		
	    /********************************************
	     * check session attribute to see if user   *
         * has selected celcius(C) or fahrenheit(F) *
         *******************************************/
			
			if  (userchoice == null) {
				modelMap.addAttribute("temperature", fahrenheit);
				modelMap.addAttribute("weatherList", weatherList);
				modelMap.addAttribute("temp", "F");
			} else if (userchoice.equals(celcius)) {
				for (Weather weather : weatherList) {
					
					int fahrenheit = weather.getHigh();
					int fahrenheitlow = weather.getLow();
					weather.setHigh(converTempToCelcius(fahrenheit));
					weather.setLow(converTempToCelcius(fahrenheitlow));
				}
				modelMap.addAttribute("weatherList", weatherList);
				modelMap.addAttribute("temp", "C");
			} else {
				modelMap.addAttribute("weatherList", weatherList);
				modelMap.addAttribute("temp", "F");
			}			
		}
	     /*************************************
		  * Convert The Temperture To Celcius *
		  * @param fahrenheit				  *
		  * @return							  *
		  ************************************/
		
		public int converTempToCelcius(int fahrenheit) {
			int celcius = (fahrenheit - 32) * 5 / 9;
			return celcius;
		}
	
		/**********************************************************
		 * Survey Input Page (Process The Survey From User Input) *
		 * @param theSurvey										  *
		 * @param theResult										  *
		 * @param flashMap										  *
		 * @return												  *
		 *********************************************************/
		
		@RequestMapping(path = "/surveyInputPage" , method = RequestMethod.POST)
		public String processSubmittingSurvey(@Valid @ModelAttribute Survey theSurvey, BindingResult theResult, RedirectAttributes flashMap) {
			
			if(theResult.hasErrors()) {
				flashMap.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", theResult);
				flashMap.addFlashAttribute("Survey", theSurvey);
				return "redirect:/surveyInputPage";
			}
			
			surveyDAO.save(theSurvey);
			
			return "redirect:/surveyOutputPage";
}
		   /************************************************
		    * Display The Favorite Parks Page              *
		    * (After Survey Submitted, Survey Output Page) *
		    * @param map								   *
		    * @return									   *
		    ***********************************************/
						
			@RequestMapping(path="/surveyOutputPage", method=RequestMethod.GET)
			public String displaySurveyOutput(ModelMap map) {
				List <SurveyResults> surveyResult = new ArrayList<SurveyResults>();
				surveyResult = surveyDAO.getAllSurveyResults();
				
				map.addAttribute("surveyResultList", surveyResult);
				return "surveyOutputPage";
				
		
			}	
		
			@RequestMapping(path = "/logoff", method = RequestMethod.POST)
		    public String logOff() {
		        auth.logOff();
		        return "redirect:/";
		    }

		    @RequestMapping(path = "/UserRegistrationPage", method = RequestMethod.GET)
		    public String register(ModelMap modelHolder) {
		        if (!modelHolder.containsAttribute("user")) {
		            modelHolder.put("user", new User());
		          
		        }
		        return "UserRegistrationPage";
		    }

		    @RequestMapping(path = "/UserRegistrationPage", method = RequestMethod.POST)
		    public String register(@Valid @ModelAttribute("user") 
		    		User user, BindingResult result, 
		    		RedirectAttributes flash) {  
		        if (result.hasErrors()) {					
		            flash.addFlashAttribute("user", user);	
		            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result); 
		            flash.addFlashAttribute("message", "Please fix the following errors:"); 
		            return "redirect:/UserRegistrationPage";	
		        }
		        auth.register(user.getUserName(), user.getPassword(), user.getPasswordHint(), user.getEmail()); 
		        return "redirect:/"; 

		    }	
}
