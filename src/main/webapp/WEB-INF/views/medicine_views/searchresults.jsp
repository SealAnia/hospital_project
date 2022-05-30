<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SEARCH RESULTS</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Medicine</th>
				<th>Frequency</th>
			</tr>
			<c:forEach items = "${results}" var = "medicine">
			<tr>
				<td>
					<a href="<c:url value="/medicines/${medicine.getId()}"/>">
					${medicine.id}</a>
				</td>
				<td>
					${medicine.name}
				</td>
				<td>
					${medicine.numberPerDay}
				</td>
				<td>
					<a href="<c:url value="/showeditmedicine/${medicine.getId()}"/>">
    				edit</a>
				</td>
				<td>
					<a href="<c:url value="/deletemedicine/${medicine.getId()}"/>"> 
    				delete</a>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>