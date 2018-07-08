<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="CharacterCreationBase">
<jsp:attribute name="title">Character Base Creation</jsp:attribute>
<jsp:body>


<c:choose>
	<c:when test="${noUserCampaign}">
		<h2>You are not assigned to any campaign</h2>
	</c:when>
	<c:otherwise>
		<div>
			<form action="setUserCampaign" method="GET">
				<select name="userCampaignId">
					<c:forEach var="userCampaign" items="${userCampaigns}">
						<option value="${userCampaign.getId()}" <c:if test="${userCampaignId == userCampaign.getId()}">selected</c:if>>${userCampaign.getCampaign().getName()}</option>
					</c:forEach>
				</select>
				<input type="submit" Value="Submit"></input>
			</form>
		</div>
		<div>
			<form action="handleBaseInput" method="POST">
				<input type="text" name="characterName" required placeholder="Character Name" maxlength=50></input>
				<label>Character Name</label>
		
				<input type="text" name="deity" placeholder="Deity"></input>
				<label>Deity</label>
				
				<input type="text" name="homeland" placeholder="Homeland" maxlength=50></input>
				<label>Homeland</label>
				
				<input type="radio" id="gender1" value="male" name="gender" checked></input>
				<label for="gender1">Male</label>
				<input type="radio" id="gender2" value="female" name="gender"></input>
				<label for="gender2">Female</label>
		
				<select name="alignment">
					<option value="CG">Chaotic Good</option>
					<option value="CN">Chaotic Neutral</option>
					<option value="LG">Lawful Good</option>
					<option value="LN">Lawful Neutral</option>
					<option value="NN">Neutral</option>
					<option value="NG">Neutral Good</option>
				</select>
				
				<select name="hair">
					<option value="black">Black</option>
					<option value="brown">Brown</option>
					<option value="red">Red</option>
					<option value="gray">Gray</option>
					<option value="fair">Fair</option>
				</select>
		
				<select name="eye">
					<option value="brown">Brown</option>
					<option value="blue">Blue</option>
					<option value="green">Green</option>
					<option value="gray">Gray</option>
				</select>
				
				<select name="race">
					<option value="Human">Human</option>
					<option value="Elf">Elf</option>
					<option value="Half Elf">Half Elf</option>
					<option value="Half Orc">Half Orc</option>
					<option value="Dwarf">Dwarf</option>
					<option value="Halfling">Halfling</option>
					<option value="Gnome">Gnome</option>
				</select>
		
				<input type="number" name="age" placeholder="age" max=350 min=12 value=12></inpu>
				
				<input type="number" name="weight" placeholder="weight (lb)" max=300 min=25 value=25></inpu>
				
				<input type="number" name="height" placeholder="height (cm)" max=220 min=80 value=80></inpu>
				
				<input type="submit" value="Submit"></iput>
			</form>
		</div>
	</c:otherwise>
</c:choose>
<c:if test="${errorOccured}">
	<div class="error">
		<h2>${errorMsg}</h2>	
	</div>
</c:if>
</jsp:body>
</t:layout>