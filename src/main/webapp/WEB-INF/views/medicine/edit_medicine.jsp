<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE MEDICINE INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/edit_medicine" var="medicine"/>
	
	<spring_form:form action="${medicine}" method="post" 
	modelAttribute = "newMedicine">
	
	<spring_form:hidden path="id" value = "${newMedicine.getId()}"/>
	
	<spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="text" path="name"/><br>
    
    <spring_form:label path="numberPerDay">FREQUENCY:</spring_form:label>
    <spring_form:input type="number" step = "0.1" min = "0" path="numberPerDay"/><br>
    
    <input type="submit" value="Submit">
    
	</spring_form:form>

</body>
</html>