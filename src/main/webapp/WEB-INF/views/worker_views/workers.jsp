<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
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
		<form action = "/workers/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Role</th>
				<th>Department</th>
			</tr>
			<c:forEach items = "${users}" var = "worker">
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
				<td>
					${worker.getRole().getName()}
				</td>
				<td>
					${worker.getDept().getName()}
				</td>
				<td>
					<a href="<c:url value="/worker?id=${worker.getUserId()}"/>"> 
    				view details</a>
				</td>
				<td>
					<a href="<c:url value="/showeditworker/${worker.getUserId()}"/>">
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
		<p>
			<a href="<c:url value="/roles"/>">Find Workers by Role</a><br>
		</p>
		<p>
			<a href="<c:url value="/showworkerform"/>"> Add new Worker</a><br>
		</p>
		<p>
			<a href="<c:url value="/main"/>">Back to Main Menu</a>
		</p>
	</div>
</body>
</html>