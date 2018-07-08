<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="characterTalentSelection">
<jsp:attribute name="title">Talent Selection</jsp:attribute>
<jsp:body>

	<c:choose>
		<c:when test="${errorActive}">
			<div class="${errorStyle}">
				<h2>${errorMsg}</h2>
			</div>
		</c:when>
		<c:otherwise>
			<h1>Select Talent/s:</h1>
			<c:if test="${warningActive}">
				<div class="${warningStyle}">
					<h2>${warningMsg}</h2>
				</div>
			</c:if>
			<div>
				<table>
					<thead>
						<tr>
							<th>Talent Name</th>
							<th>Combat Talent</th>
							<th>Condition/s</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="talent" items="${talents}">
							<tr>
								<td>${talent.getName()}</td>
								<td>
									<form>
										<input type="checkbox"></input>
									</form>
								</td>
								<c:if test="${talent.getSizeOfTalentConditions() > 0}">
									<td></td>
									<td>${talent.getDescription()}</td>
									<td>
										<form action="processTalent" method="POST">
											<input style="display: none;" type="number" value="${talent.getId()}" name="talentId"></input>
											<input type="submit" value="Submit"></input>
										</form>
									</td>
								</c:if>
								<c:choose>
									<c:when test="${talent.getSizeOfTalentConditions() > 0}">
										<c:forEach var="condition" items="${talent.getTalentConditions()}">
											<tr>
												<td></td>
												<td></td>
												<td>${condition.getKind()}${condition.getValue()}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td>-----------</td>
										<td>${talent.getDescription()}</td>
										<td>
											<form action="processTalent" method="POST">
												<input style="display: none;" type="number" value="${talent.getId()}" name="talentId" hidden></input>
												<input type="submit" value="Submit"></input>
											</form>
										</td>
									</c:otherwise>
								</c:choose>
							</tr>	
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:otherwise>
	</c:choose>

</jsp:body>
</t:layout>