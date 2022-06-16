<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE OPERATION INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/operations" var="operation"/>

	<form action="${operation}" method="POST">
		<label for="id">ID</label>
    	<input type="number" name="id" id="id">
    	<label for="name">Date</label>
    	<input type="date" name="name" id="date">
    	<label for="name">Comments</label>
    	<input type="text" name="name" id="comments">
    	<input type="submit" value="Edit">
	</form>

</body>
</html>