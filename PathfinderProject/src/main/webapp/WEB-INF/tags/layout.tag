<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="current" required="true"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>
		<jsp:invoke fragment="title"></jsp:invoke>
	</title>
	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"  />
</head>
<body>
	<div class="container">
		<a href="/PathfinderProject/mainCockpit">
			<img id="nav-img" src="${pageContext.request.contextPath}/resources/img/navbar.jpg">
		</a>
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
                	<a href="/PathfinderProject/baseCreation">Character Creation</a>
                </li>
            </ul>
        </div>
        <div>
        	<a href="logout" class="button right">Logout</a>
        </div>
	    <jsp:doBody></jsp:doBody>
   </div>
   <footer id="footer">
       <span>© 2018 Rahner Cooperation</span>
   </footer>
</body>
</html>