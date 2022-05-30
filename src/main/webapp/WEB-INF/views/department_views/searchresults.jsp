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
				<th>Department name</th>
			</tr>
			<c:forEach items = "${results}" var = "department">
			<tr>
				<td>
    				<a href="<c:url value="/departments/${department.getId()}"/>">
    				${department.id}</a>
				</td>
				<td>
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

</body>
</html>