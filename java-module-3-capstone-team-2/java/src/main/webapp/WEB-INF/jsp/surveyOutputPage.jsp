<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:url var="favoriteParkPage" value="/surveyOutputPage"/>

<title class="surveyOutputTitle"> Favorite Parks </title>
</head>
<body class="surveyOutput">
<c:forEach var="surveys" items="${surveyResultList}">
	<div class="survey">
		<li>
		<img class="parking" src="img/parks/${surveys.parkCode.toLowerCase()}.jpg"/>
			<p class="favoritePark"> Favoite Park:   ${surveys.parkName} </p>
			<p class="favoritePark">Survey Count:   ${surveys.surveySum} </p>
		</li>
	</div>
		


</c:forEach>




</body>
</html>
<c:import url="/WEB-INF/common/footer.jsp" />