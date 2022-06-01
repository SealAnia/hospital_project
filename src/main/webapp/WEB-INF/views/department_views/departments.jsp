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

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>

<body>
	<div>
		<h4>HOSPITAL DEPARTMENTS</h4>
	</div>
	<div>
		<form action = "/departments/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
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
					${department.name}
				</td>
				<td>
					<a href="<c:url value="/department?id=${department.getId()}"/>"> 
    				view details</a>
				</td>
				<td>
					<a href="<c:url value="/showeditdepartment/${department.getId()}"/>">
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
	
	<div>
		<form action = "/departments/sortedbyname/asc">
			<button>SORT BY NAME ASCENDING</button>
		</form>
		<form action = "/departments/sortedbyname/desc">
			<button>SORT BY NAME DESCENDING</button>
		</form>
		<form action = "/departments">
			<button>REVERT</button>
		</form>
	</div>
	<a href="<c:url value="/showdepartmentform"/>"> Add new Department</a>
	<p>
		<a href="<c:url value="/main"/>"> Back to Main Menu</a>
	</p>
	
</body>
</html>