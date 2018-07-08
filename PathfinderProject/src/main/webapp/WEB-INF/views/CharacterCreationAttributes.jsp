<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="CharacterCreationAttributes">
<jsp:attribute name="title">Character Creation Attributes</jsp:attribute>
<jsp:body>

<c:choose>
	<c:when test="${errorActive}">
		<div class="${errorStyle}">
			<h2>${errorMsg}</h2>
		</div>
	</c:when>
	<c:otherwise>
		<h2>Please set character attributes</h2>
		<div class="attribute-box">
			<ul>
				<li>
					<form action="attributes/validateAttributes" method="POST">
						<c:forEach items="${attributes}" var="attribute">
							<input id="${attribute}" name="${attribute}" type="number" placeholder=10 min=7 max=18 value=10 required onchange="alterEnhancementPoints()"><strong>${attribute}</strong></input><br>
						</c:forEach>
						<input id="submitButton" type="submit" value="Submit" disabled="disabled"></input>
					</form>
				</li>
			</ul>
		</div>
		<div>
			<form>
				<input id="enhancementPoints" name="enhancementPoints" type="number" value="${enhancementPoints}" readonly>Remaining enhancement Points</input>
			</form>
		</div>
		<c:if test="${warningActive}">
			<div class="${warningStyle}">
				<h2>${warningMsg}</h2>
			</div>
		</c:if>
	</c:otherwise>
</c:choose>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/attributeSelection.js"></script>

</jsp:body>
</t:layout>