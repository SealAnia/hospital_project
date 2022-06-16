<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${role.getName()}s:</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	
	<div>
		<h3>${role.getName()}s:</h3>
	</div>
	
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Department</th>
				<th>Role</th>
			</tr>
		<c:forEach items = "${role.getUsers()}" var = "worker">
			<tr>
				<td><c:out value = "${worker.getUserId()}"/></td>
				<td><c:out value = "${worker.getName()}"/></td>
				<td><c:out value = "${worker.getSurname()}"/></td>
				<td><c:out value = "${worker.getDept().getName()}"/></td>
				<td><c:out value = "${worker.getRole().getName()}"/></td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	<div>
		<a href="<c:url value="workers"/>">All Workers</a><br>
		<a href="<c:url value="/main"/>">Back to Main Menu</a>
	</div>

</body>
</html>