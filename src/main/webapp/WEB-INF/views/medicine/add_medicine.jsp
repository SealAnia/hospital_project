<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW MEDICINE</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/medicines" var="medicine"/>
	
	<spring_form:form action="${medicine}" method="post" modelAttribute="medicine">
    <spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="text" path="name"/><br>
    
    <spring_form:label path="numberPerDay">FREQUENCY:</spring_form:label>
    <spring_form:input type="number" step = "0.1" min = "0" path="numberPerDay"/><br>
    
    <label for = "patientid">PATIENT</label>
    <input type = "number" id = "patientid" name = "patientid"/>
    
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>