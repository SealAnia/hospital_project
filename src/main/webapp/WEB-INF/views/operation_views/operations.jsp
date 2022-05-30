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
<title>OPERATIONS</title>

<link href="<c:url value="/resources/css/MainStyle.css" />" rel="stylesheet">

</head>
<body>
	<div>
		<h4>OPERATIONS LIST</h4>
	</div>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Comments</th>
			</tr>
			<c:forEach items = "${operations}" var = "operation">
			<tr>
				<td><c:out value = "${operation.getId()}"/></td>
				<td><c:out value = "${operation.getDate()}"/></td>
				<td><c:out value = "${operation.getComments()}"/></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>