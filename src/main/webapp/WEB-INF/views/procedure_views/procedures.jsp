<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROCEDURES</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	<div>
		<h4>ALL PROCEDURES</h4>
	</div>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Instruction</th>
				<th>Date</th>
			</tr>
			<c:forEach items = "${procedures}" var = "procedure">
			<tr>
				<td><c:out value = "${procedure.getProcedureId()}"/></td>
				<td><c:out value = "${procedure.getName()}"/></td>
				<td><c:out value = "${procedure.getDetails()}"/></td>
				<td><c:out value = "${procedure.getDate()}"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>