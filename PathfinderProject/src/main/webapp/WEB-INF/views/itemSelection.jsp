<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="itemSelection">
<jsp:attribute name="title">Item Selection</jsp:attribute>
<jsp:body>

	<c:choose>
		<c:when test="${errorActive}">
			<div class="${errorStyle}">
				<h2>${errorMsg}</h2>
			</div>
		</c:when>
		<c:otherwise>
			<h1>Select Item Category</h1>
			<form id="categoryForm" action="showItemsForCategory" method="POST" onchange='doSubmit()'>
				<select name="category">
					<c:forEach var="category" items="${categories}">
						<option <c:if test="${category == selectedCategory}">selected</c:if> >${category}</option>
					</c:forEach>
				</select>
			</form>
			<h3>Available Money</h3>
			<div class="money-block">
				<form>
					<label>Platin</label>
					<input type="number" value="${platin}" readonly="readonly"></input>
					<label>Gold</label>
					<input type="number" value="${gold}" readonly="readonly"></input>
					<label>Silver</label>
					<input type="number" value="${silver}" readonly="readonly"></input>
					<label>Copper</label>
					<input type="number" value="${copper}" readonly="readonly"></input>
				</form>	
			</div>
			
			<c:if test="${warningActive}">
				<div class="${warningStyle}">
					<h2>${warningMsg}</h2>
				</div>
			</c:if>
			
			<h2>Select items to buy: </h2>
			<div class="item-table">
				<table>
					<thead>
						<tr>
							<th>Name</th>
							<th>Prize</th>
							<th>Weight</th>
							<th>Category</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${items}">
							<tr>
								<th>${item.getName()}</th>
								<th>${item.showPrizeInAppropriateCurrency()}</th>
								<th>${item.getWeight()}</th>
								<th>${item.getCategory()}</th>
								<th>
									<form action="buyItems" method="POST">
										<input type="number" min=1 placeholder="0" name="amountToBuy" required></input>
										<input type="number" style="display: none;" name="itemId" value="${item.getId()}"></input>
										<input type="submit" value="Buy"></input>
									</form>
								</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</c:otherwise>
	</c:choose>

<script type="text/javascript">
	function doSubmit() {
		document.getElementById("categoryForm").submit();
	}
</script>
</jsp:body>
</t:layout>