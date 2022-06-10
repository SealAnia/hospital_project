<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE DEPARTMENT INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/departments" var="department"/>
	<form action="${department}" method="POST">
	
		<!-- 
		<label for="id">ID</label>
    	<input type="number" name="id" id="id">
		 -->
		 
    	<label for="name">Name</label>
    	<input type="text" name="name" id="name">
    	<input type="submit" value="Edit">
	</form>

</body>
</html>