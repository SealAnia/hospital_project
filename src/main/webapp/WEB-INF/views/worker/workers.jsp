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
					<a href="<c:url value="/deleteworkerinfo/${worker.getUserId()}"/>"> 
    				delete</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	<div>
		<form action = "/roles">
			<button>Find Workers by Role</button>
		</form>
		<form action = "/showworkerform">
			<button>Add New Worker</button>
		</form>
		<form action = "/main">
			<button>Back to Main Menu</button>
		</form>
	</div>
</body>
</html>