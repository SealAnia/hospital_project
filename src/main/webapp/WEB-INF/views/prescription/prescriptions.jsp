<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ALL PRESCRIPTIONS</title>


<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

<c:forEach items = "${prescriptions}" var = "prescription">
	${prescription.getPatient().getName()} - ${prescription.getPatient().getSurname()} - 
	${prescription.getPatient().getDepartment().getName()} - ${prescription.getMedicine().getName()}<br>
</c:forEach>

</body>
</html>