<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="register">
<jsp:attribute name="title">Register</jsp:attribute>
<jsp:body>
        <div>
        	<c:if test="${infoActive}">
        		<div class="${infoStyle}">
        			<h2>${infoMsg}</h2>
        		</div>
        	</c:if>
	        <form class="register-form" action="register" method="POST">
	            <div class="form-gruppe">
	                <label>Username: </label>
	                <input type="text" name="name">
	            </div>
	            <div class="form-gruppe">
	                <label>Email: </label>
	                <input type="email" name="email">
	            </div>
	            <div class="form-gruppe">
	                <label>Password: </label>
	                <input type="password" name="password">
	            </div>
	            <div class="form-gruppe">
	                <label>Verify Password: </label>
	                <input type="password" name="passwordVerification">
	            </div>
                <div class="form-gruppe" id="reg-button">
	                <input type="submit" class="button" value="Submit">
	            </div>
		        <c:if test="${passwordIdentically == false}">
		        	<p class="error-Msg">Password and password verification not identically!</p>
		        </c:if>
		        <c:if test="${usernameInDb == true}">
		        	<p class="error-Msg">Username already forgiven!</p>
		        </c:if>
		        <c:if test="${registrationSuccessful == true}">
		        	<p class="Msg">Registration successful!</p>
		        </c:if>
	        </form>
		</div>
</jsp:body>
</t:layout>