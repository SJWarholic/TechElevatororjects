<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    
<c:import url="/WEB-INF/common/header.jsp"/>
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
    		<c:url value="/homePage" var="homePageHref" />
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
            <li class= "home"><a href="/Module-3-Capstone-Team-2/homePage">HOME</a></li>
            <li class= "survey"><a href="/Module-3-Capstone-Team-2/surveyInputPage">SURVEY</a></li>
            <li class= "top"><a href="/Module-3-Capstone-Team-2/surveyOutputPage">TOP PARKS</a></li>
        </ul>
     </nav>
    </div>
    </div>
    