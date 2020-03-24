<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <c:import url="/WEB-INF/common/LoginHeader.jsp"/>

<!DOCTYPE html>
<html>

<head>

   
    <meta charset="UTF-8">
   
    <title> National Park Geek</title>
 <c:url value="/css/style.css" var="cssURL"/>
<link rel="stylesheet" type="text/css" href="${cssURL}">
    
</head>


<body>
   <div class="header-div">
     <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
    		
    		<div >
        		<a href="${homePageHref}">
        			<img id="logo" src="${logoSrc}" alt="National Park Geek logo" />
        		</a>
        </div>
    </header>
 <div class="border">
 	 <nav>
        <ul>
            <li class= "login"><a href="/Module-3-Capstone-Team-2/">Have an account? Login</a></li>
            <br>
            <li class= "register"><a href="/Module-3-Capstone-Team-2/UserRegistrationPage">Register</a></li>
            
        </ul>
     </nav>
    </div>
    </div>
    