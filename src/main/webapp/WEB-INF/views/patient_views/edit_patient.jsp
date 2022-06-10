<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE PATIENT INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/patients" var="patient"/>
	<form action="${patient}" method="POST">
		
    	<label for="name">Name</label>
    	<input type="text" name="name" id="name">
    	
    	<label for="surname">Surname</label>
    	<input type="text" name="surname" id="surname">
    	
    	<label for="diagmosis">Diagnosis</label>
    	<input type="text" name="diagmosis" id="diagmosis">
    	
    	<label for="admission">Admission Date</label>
    	<input type="date" name="admission" id="admission">
    	
    	<label for="release">Release Date</label>
    	<input type="date" name="release" id="release">
    	
    	<label for="departmentid">Department Id</label>
    	<input type="number" name="departmentid" id="departmentid">
    	
    	<input type="submit" value="Edit">
    	
	</form>

</body>
</html>