<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <c:import url="/WEB-INF/common/LoginHeader.jsp"/>


<h2>Welcome! Let's Get You Registered!!</h2>


<c:url var="RegistrationUrl" value="/UserRegistrationPage"/>
<form:form method="POST" action="${RegistrationUrl}" modelAttribute="registration">
	
	<div>
		<label for="username">Username</label>
		<form:input path="username" placeholder="enter username"/>
		<form:errors path="username" cssClass="error"/>
		
	</div><br>
		
	<div>
		<label for="password">Password</label>
		<form:input path="password" placeholder="enter password"/>
		<form:errors path="password" cssClass="error"/>
		
	</div><br>

	<div>
		<label for="email">Email</label>
		<form:input path="email" placeholder="enter Email"/>
		<form:errors path="email" cssClass="error"/>
		
	</div><br>	
	
	<div>
		<label for="passwordHint">Password Hint</label>
		<form:input path="passwordHint" placeholder="password Hint"/>
		<form:errors path="passwordHint" cssClass="error"/>
		
	</div><br>
	
	<div>
		<input style="color: white; background-color: green;" type="submit" value="Sign Me Up!"/>
	</div>
</form:form>





