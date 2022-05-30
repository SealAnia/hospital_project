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
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
			</tr>
			<c:forEach items = "${workers}" var = "worker">
			<tr>
				<td><c:out value = "${worker.getUserId()}"/></td>
				<td><c:out value = "${worker.getName()}"/></td>
				<td><c:out value = "${worker.getSurname()}"/></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>