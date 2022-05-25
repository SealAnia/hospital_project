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
<title>PATIENTS</title>
</head>
<body>
	<body>
	<div>
		<h4>PATIETNS</h4>
	</div>
	<div>
		<c:forEach items = "${patients}" var = "patient">
			<c:out value = "${patient.getPatientId()}"/>
			<c:out value = "${patient.getName()}"/>
			<c:out value = "${patient.getSurname()}"/>
			<c:out value = "${patient.getName()}"/>
			<c:out value = "${patient.getDiagnosis()}"/>
			<c:out value = "${patient.getAdmission()}"/>
			<c:out value = "${patient.getRelease()}"/>
			<c:out value = "${patient.getComments()}"/>
		</c:forEach>
	</div>
</body>
</body>
</html>