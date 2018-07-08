<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="CharacterCreationClass">
<jsp:attribute name="title">Character Class Creation</jsp:attribute>
<jsp:body>
	
	<c:choose>
		<c:when test="${errorActive}">
			<div class="${errorStyle}">
				<h2>${errorMsg}</h2>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<h1>Select Character Class</h1>
				<form action="processClass" method="POST">
					<select name="className">
						<c:forEach var="characterClass" items="${characterClasses}">
							<option value="${characterClass.getName()}">${characterClass.getName()}</option>
						</c:forEach>
					</select>
					<input type="submit" value="Submit"></input>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	
</jsp:body>
</t:layout>