<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Welcome</title>
	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"  />
</head>
<body>
	<div class="container">
        <img id="nav-img" src="${pageContext.request.contextPath}/resources/img/navbar.jpg">
        <div id="nav-bar">
            <ul>
                <li>
                    <a href="charStats">Character Stats</a>
                </li>
                <li>
                    <a href="">Character Skills</a>
                </li>
                <li>
                    <a href="">Character Talents</a>
                </li>
                <li>
                    <a href="">Character Spells</a>
                </li>
                <li>
                    <a href="">Character Items</a>
                </li>
                <li>
                    <a href="">Level Up</a>
                </li>
                <li>
                	<a href="baseCreation">Character Creation</a>
                </li>
            </ul>
        </div>
	    <div class="green-box index-box">
	       <a href="login" class="button">Login</a>
	       <a href="register" class="button">Register</a>
		</div>
   </div>
	
	<footer id="footer">
       <span>© 2018 Rahner Cooperation</span>
   </footer>
</body>
</html>