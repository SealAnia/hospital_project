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
		<form action = "/operations/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
		<table>
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Comments</th>
			</tr>
			<c:forEach items = "${operations}" var = "operation">
			<tr>
				<td>
					<a href="<c:url value="/operations/${operation.getId()}"/>">
					${operation.getId()}</a>
				</td>
				<td>
					${operation.getDate()}
				</td>
				<td>
					${operation.getComments()}
				</td>
				<td>
					<a href="<c:url value="/operation?id=${operation.getId()}"/>"> 
    				view details</a>
				</td>
				<td>
					<a href="<c:url value="/showeditoperation/${operation.getId()}"/>">
    				edit</a>
				</td>
				<td>
					<a href="<c:url value="/deleteoperation/${operation.getId()}"/>"> 
    				delete</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	<div>
		<form action = "/operations/sortedbydate/asc">
			<button>SORT BY DATE ASCENDING</button>
		</form>
		<form action = "/operations/sortedbydate/desc">
			<button>SORT BY DATE DESCENDING</button>
		</form>
		<form action = "/operations">
			<button>REVERT</button>
		</form>
	</div>
	<a href="<c:url value="/showoperationform"/>"> Add new Operation</a>
	<p>
		<a href="<c:url value="/main"/>"> Back to Main Menu</a>
	</p>
</body>
</html>