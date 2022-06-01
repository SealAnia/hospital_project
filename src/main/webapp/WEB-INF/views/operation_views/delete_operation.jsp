<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE OPERATION INFO</title>
</head>
<body>

	<c:url value="/deleteoperation/${operation.getId()}" var="operation"/>
	
	All information about the operation will Be deleted
	<a href="<c:url value="/operations"/>"> OK </a>

</body>
</html>