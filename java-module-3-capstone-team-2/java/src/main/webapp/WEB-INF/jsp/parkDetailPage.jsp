<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>




<c:import url="/WEB-INF/common/header.jsp"/>

<body>
<div id="main-content">
    
    <section id="parkDescription">
    		
    		<div>
    			<img class="parkimg" src="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
    		</div>
    			<div id="infoContainer">
    			<div id="quote">"${park.quote}"</div>
       			<div id="quoteSource">-${park.quoteSource}</div>
       		</div>
    		
    	
    		<div id="header">
    			<div><h1 id="parkName">${park.parkName}</h1></div>
    			
    		</div>
    		
    		
        <div class="parkdesc" id="description">${park.description}</div>
        <h3>Park Facts and More!</h3>
        <div id="facts">
        		
        		<div id="wrap">
        			<div id="fact-box">
        				<div class="table"><div class="left-column fact-box">Park Area: </div><div class="fact-box">${park.acreage} acres</div></div>
        				<div class="table"><div class="left-column">Elevation: </div><div>${park.elevation} feet</div></div>
        				<div class="table"><div class="left-column">Total Length of Park Trails: </div><div>${park.miles} miles</div></div>        
       				<div class="table"><div class="left-column">Climate: </div><div>${park.climate}</div></div>
        				<div class="table"><div class="left-column">Number of animal species: </div><div>${park.animals}</div></div>
        				<div class="table"><div class="left-column">Founded in: </div><div>${park.year}</div></div>
        				<div class="table"><div class="left-column">Number of Annual Visitors: </div><div>${park.visitors}</div></div>
        				<div class="table"><div class="left-column">Number of campsites: </div><div>${park.campNum}</div></div>
        				<div class="table"><div class="left-column">Entry Fee: </div><div>$${park.fee}</div></div>
        			</div>
        		</div>
        </div>
     </section>
    
     <section id="parkWeather">
     	<h2>The 5-Day Weather Forecast For This Park!</h2>
     	<div id="scaleChoice">
     		<c:url var="temperatureLink" value="/parkDetailPage">
     			<c:param name="temperature" value="celcius" />
     			<c:param name="parkCode" value="${park.parkCode}" />
     		</c:url>
     		<div class="tempChoice">
     		<a href="${temperatureLink}">Show Temp In Celcius</a></div>
     		<c:url var="temperatureLink" value="/parkDetailPage">
     			<c:param name="temperature" value="fahrenheit" />
     			<c:param name="parkCode" value="${park.parkCode}" />
     		</c:url>
     		<br>
     		<div class="tempChoice">
     		<a href="${temperatureLink}">Show Temp In Fahrenheit</a></div>
     	</div>
     	<div id="forecast">
     	<c:forEach var="item" items="${weatherList}">
     		<c:choose>
     			<c:when test="${item.dayNum==1}">
     				<div class="today">
     					<div><img src="img/weather/${fn:replace(item.forecast,' ','')}.png"></div>
     					<div>High ${item.high} ${temp}</div>
     					<div class="low">Low ${item.low} ${temp}</div>
     					<div class="forecastWord">${item.forecast}</div>
     					<div class="advisory">${advisoryList[0].advisory}</div>
     				</div>
     			</c:when>
     			<c:otherwise>
     				<div class="future">
     					<div><img src="img/weather/${fn:replace(item.forecast,' ','')}.png"></div>
     					<div>High ${item.high} ${temp}</div>
     					<div class="low">Low ${item.low} ${temp}</div>
     					<div class="forecastWord">${item.forecast}</div>
     					<div class="advisory">${advisoryList[item.dayNum-1].advisory}</div>
     				</div>
     			</c:otherwise>
     		</c:choose>
     	</c:forEach>
     	</div>
     </section>
</div>
</body>
<c:import url="/WEB-INF/common/footer.jsp" />