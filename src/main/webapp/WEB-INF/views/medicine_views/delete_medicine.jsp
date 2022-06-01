<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE MEDICINE INFO</title>
</head>
<body>

	<c:url value="/deletemedicine/${medicine.getId()}" var="medicine"/>
	
	Medicine info is deleted
	<a href="<c:url value="/medicines"/>"> OK </a>

</body>
</html>