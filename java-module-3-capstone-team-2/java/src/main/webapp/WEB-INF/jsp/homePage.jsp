<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/common/header.jsp" />

    
<div id="main-content">
	<div class="survey-main">
   	  <h2 style="font-size: 30px; margin-left: 150px;">Our Parks</h2>
    </div>
    <c:forEach var="item" items="${parks}">
        <section>
            <div class="homePage">
            		<c:url var="parkDetailPageLink" value="/parkDetailPage">
            			<c:param name="parkCode" value="${item.parkCode}"/>
            		</c:url>
            		<a href="${parkDetailPageLink}"><img src="img/parks/${item.parkCode.toLowerCase()}.jpg"/></a>
            </div>
            <div id="park-text"><h3 id="park-name"><a href="${parkDetailPageLink}">${item.parkName}</a></h3>
            <p id="park-description">${item.description}</p></div>
            <br/>
        </section>
    </c:forEach>
</div>

<c:import url="/WEB-INF/common/footer.jsp" />