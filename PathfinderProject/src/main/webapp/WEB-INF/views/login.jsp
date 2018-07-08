<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="login">
<jsp:attribute name="title">Login</jsp:attribute>
<jsp:body>
       <div>
	       <form class="register-form" action="login" method="POST">
		       <div class="form-gruppe">
		           <label>Username: </label>
		           <input type="text" name="name">
		       </div>
		       <div class="form-gruppe">
		           <label>Password: </label>
		           <input type="password" name="password">
		       </div>
		          <div class="form-gruppe" id="log-button">
		           <input type="submit" class="button" value="Submit">
		       </div>
		       <c:if test="${warningActive}">
		       		<div class="${warningStyle}">
		       			<h2>${warningMsg}</h2>
		       		</div>
		       </c:if>
		       <c:if test="${infoActive}">
		       		<div class="${infoStyle}">
		       			<h2>${infoMsg}</h2>
		       			<a href="mainCockpit" class="button">Go to MainPage</a>
		       		</div>
		       </c:if>
	      </form>
	  </div>
</jsp:body>
</t:layout>
       
