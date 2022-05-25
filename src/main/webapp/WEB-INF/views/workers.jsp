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
<title>DOCTORS AND NURSES</title>
</head>
<body>
	<div>
		<h4>HOSPITAL STUFF</h4>
	</div>
	<div>
		<c:forEach items = "${workers}" var = "worker">
			<c:out value = "${worker.getUserId()}"/>
			<c:out value = "${worker.getName()}"/>
			<c:out value = "${worker.getSurname()}"/>
			<c:out value = "${worker.getDepartmentId()}"/>
			<c:out value = "${worker.getRoleId()}"/>
		</c:forEach>
	</div>
</body>
</html>