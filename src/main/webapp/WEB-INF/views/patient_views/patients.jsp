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
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Diagnosis</th>
				<th>Admission</th>
				<th>Release</th>
				<th>Comments</th>
			</tr>
		<c:forEach items = "${patients}" var = "patient">
			<tr>
				<td><c:out value = "${patient.getPatientId()}"/></td>
				<td><c:out value = "${patient.getName()}"/></td>
				<td><c:out value = "${patient.getSurname()}"/></td>
				<td><c:out value = "${patient.getDiagnosis()}"/></td>
				<td><c:out value = "${patient.getAdmission()}"/></td>
				<td><c:out value = "${patient.getRelease()}"/></td>
				<td><c:out value = "${patient.getComments()}"/></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</body>
</html>