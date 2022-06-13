<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<th>Name</th>
				<th>Surname</th>
				<th>Role</th>
				<th>Department</th>
			</tr>
			<c:forEach items = "${results}" var = "worker">
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
		<form action = "/workers">
			<button>BACK</button>
		</form>
	</div>
</body>
</html>