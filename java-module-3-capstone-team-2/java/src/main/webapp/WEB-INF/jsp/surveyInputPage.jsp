<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="/WEB-INF/common/header.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title class="surveyTitle"> Welcome To The Favorite Park Survey </title>

</head>
<br>
<body class="surveyInput">
<c:url var="formAction" value="/surveyInputPage"/>
 <form:form method="POST" action="${formAction}" modelAttribute="Survey">
    	
		<label for="parkName">Park Name:</label> 
		<select class="${parkCode}" name="parkCode" id="basementCat">
			<c:forEach items="${parks}" var="aPark">
			<option value="${aPark.parkCode}">${aPark.parkName}</option>
			</c:forEach>
			
		</select>
		<div>
    	<label for="email">E-mail</label>
    		<form:input path="email"/>
    		<form:errors path="email" cssClass="error"/>
    	</div>
   	    
   	    <div class="stateList">
		<label for="state">State of Residence:</label> 
		<select name="state" id="state">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</select>
	</div>
	  
   	    <div class="activityLevel">
		<label for="activityLevel">Activity Level:</label> 
		<select name="activityLevel" id="activityLevel">
			<option value="inactive">inactive</option>
			<option value="sedentary">sedentary</option>
			<option value="active">active</option>
			<option value="extremely active">extremely active</option>
		</select>
    		
	 </div>
     	<input class="forSubmitButton" type="submit" value="Submit Survey"/>		
    </form:form>








<c:import url="/WEB-INF/common/footer.jsp" />