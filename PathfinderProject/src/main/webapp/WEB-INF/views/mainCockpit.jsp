<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="MainCockpit">
<jsp:attribute name="title">Main Cockpit</jsp:attribute>
<jsp:body>

	<div>
		<c:choose>
			<c:when test="${userHasCampaign}">
			
			</c:when>
			<c:otherwise>
				<h4>You are not assigned to any campaign!</h4>
				<a href="browseCampaigns" class="button">Browse Campaigns</a>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<h3>Info</h3>
		<ul>
			<li>
				Du solltest mal eine Campagne erstellen
			</li>
		</ul>
	</div>
	<div>
		<div>
			<h3>Campaign</h3>
			<ul>
				<li>
					<a href="#">Create Campaign</a>
				</li>
				<li>
					<a href="#">Browse Campaigns</a>
				</li>
				<li>
					<a href="#">Maintain Campaign</a>
				</li>
			</ul>
		</div>
		<div>
			<h3>Character</h3>
			<ul>
				<li>
					<a href="#">Create Character</a>
				</li>
				<li>
					<a href="#">Maintain Character</a>
				</li>
			</ul>
		</div>
	</div>

</jsp:body>
</t:layout>