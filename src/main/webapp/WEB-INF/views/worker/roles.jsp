<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WORKERS BY ROLE</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	<div>
		<h4>WORKERS BY ROLE</h4>
	</div>
	
	<div>
		<c:forEach items = "${roles}" var = "role">
			<a href="<c:url value="/role?roleid=${role.getRoleId()}"/>">
				${role.getRoleId()}</a>
				${role.getName()}s:<br>
			<br>
		</c:forEach>
	</div>
	
	<div>
		<p>
			<a href="<c:url value="/workers/page1"/>">All Workers</a><br>
		</p>
		<p>
			<a href="<c:url value="/main"/>">Back to Main Menu</a>
		</p>
	</div>
</body>
</html>