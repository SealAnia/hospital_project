<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.hospital.controller.DepartmentController" %>
<%@ page import="com.example.hospital.model.entity.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOCTORS AND NURSES</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

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
				<td>
				<a href="<c:url value="/workers/${worker.getUserId()}"/>">
					${worker.getUserId()}</a>
				</td>
				<td>
					${worker.getName()}
				</td>
				<td>
					${worker.getSurname()}
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>