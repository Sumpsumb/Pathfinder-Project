<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="CharacterSkillSelection">
<jsp:attribute name="title">Character Skill Selection</jsp:attribute>
<jsp:body>

	<c:choose>
		<c:when test="${errorActive}">
			<div class="${errorStyle}">
				<h2>${errorMsg}</h2>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<h2>Select skills</h2>
				<h3>Avaiable Skillpoints: ${skillpoints}</h3>
				<c:if test="${warningActive}">
					<div class="${warningStyle}">
						<h2>${warningMsg}</h2>
					</div>
				</c:if>
				<table>
					<thead>
						<tr>
							<th>Skill Name</th>
							<th>Full Bonus</th>
							<th>Primary Attribute</th>
							<th>Attribute Mod</th>
							<th>Rank</th>
							<th>Other Mod</th>
							<th>Class Skill</th>
							<th>Trained Only</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="characterSkill" items="${characterSkills}">
							<tr>
								<td>${characterSkill.getSkill().getName()}</td>
								<td>${characterSkill.getFullBonus()}</td>
								<td>${characterSkill.getSkill().getPrimaryAttribute()}</td>
								<td>${characterSkill.getAttributeMod()}</td>
								<td>${characterSkill.getRang()}</td>
								<td>${characterSkill.getOtherMod()}</td>
								<form>
									<td>
										<input type="checkbox" <c:if test="${characterSkill.getIsClassSkill() == 'Y'}">checked</c:if> disabled></input>
									</td>
									<td>
										<input type="checkbox" <c:if test="${characterSkill.getSkill().getTrainedOnly() == 'Y'}">checked</c:if> disabled></input>
									</td>	
								</form>
								<td>
									<form method="POST" action="processSkill">
										<input style="display: none;" type="text" name="characterSkillName" value="${characterSkill.getSkill().getName()}" hidden></input>
										<input type="submit" value="Select"></input>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:otherwise>
	</c:choose>

</jsp:body>
</t:layout>