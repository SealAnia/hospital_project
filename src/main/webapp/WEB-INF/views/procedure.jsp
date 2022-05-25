<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.hospital.controller.DepartmentController" %>
<%@ page import="com.example.hospital.model.entity.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROCEDURES</title>
</head>
<body>
	<div>
		<h4>ALL PROCEDURES</h4>
	</div>
	<div>
		<c:forEach items = "${procedures}" var = "procedure">
			<c:out value = "${procedure.getProcedureId()}"/>
			<c:out value = "${procedure.getName()}"/>
			<c:out value = "${procedure.getDetails()}"/>
			<c:out value = "${procedure.getDate()}"/>
		</c:forEach>
	</div>
</body>
</html>