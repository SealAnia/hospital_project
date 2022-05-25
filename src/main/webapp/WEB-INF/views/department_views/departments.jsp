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
<title>DEPARTMENTS</title>
</head>
<style>
	table {
		border: 1px solid grey;
	}
	th {
		border: 1px solid grey;
	}
	td {
		border: 1px solid grey;
	}
</style>
<body>
	<div>
		<h4>HOSPITAL DEPARTMENTS</h4>
	</div>
	<div>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Department name</th>
			</tr>
			<c:forEach items = "${departments}" var = "department">
			<tr>
				<td>
    				<a href="<c:url value="/departments/${department.getId()}"/>">
    				${department.id}</a>
				</td>
				<td>
				<!-- <a href="<c:url value="/department?id=${department.getId()}"/>"></a> -->
					${department.name}
				
				</td>
				<td>
					<a href="<c:url value="/showeditform/${department.getId()}"/>">
    				edit</a>
				</td>
				<td>
					<a href="<c:url value="/deletedepartment/${department.getId()}"/>"> 
    				delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</div>
	
	<a href="<c:url value="/showdepartmentform"/>"> Add new Department</a>
	
</body>
</html>