<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="CampaignBrowser">
<jsp:attribute name="title">Campaign Browser</jsp:attribute>
<jsp:body>
	
	<div>
		<h1>Published Campaigns</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Owner</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="campaign" items="${campaigns}">
				<tr>
					<td>${campaign.getName()}</td>
					<td>${campaign.getUser().getName()}</td>
					<td>
						<form action="createUserCampaign" method="post">
							<input style="display: none;" type="number" name="campaignId" value="${campaign.getId()}"></input>
							<input type="submit" value="Copy Campaign"></input>
						</form>
					</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	</div>

</jsp:body>
</t:layout>