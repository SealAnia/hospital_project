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

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Comments</th>
			</tr>
			<c:forEach items = "${results}" var = "operation">
			<tr>
				<td>
    				<a href="<c:url value="/operations/${operation.getId()}"/>">
    				${operation.id}</a>
				</td>
				<td>
					${operation.date}
				</td>
				<td>
					${operation.comments}
				</td>
				<td>
					<a href="<c:url value="/showeditform/${operation.getId()}"/>">
    				edit</a>
				</td>
				<td>
					<a href="<c:url value="/deleteoperationt/${operation.getId()}"/>"> 
    				delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>