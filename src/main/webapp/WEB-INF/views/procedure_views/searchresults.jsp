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
				<th>Instruction</th>
				<th>Date</th>
			</tr>
			<c:forEach items = "${results}" var = "procedure">
			<tr>
				<td>
					<a href="<c:url value="/procedures/${procedure.getProcedureId()}"/>">
					${procedure.getProcedureId()}</a>
				</td>
				<td>
					${procedure.getName()}
				</td>
				<td>
					${procedure.getDetails()}
				</td>
				<td>
					${procedure.getDate()}
				</td>
				<td>
					<a href="<c:url value="/procedure?procedureid=${procedure.getProcedureId()}"/>"> 
    				view details</a>
				</td>
				<td>
					<a href="<c:url value="/showeditprocedure/${procedure.getProcedureId()}"/>">
    				edit</a>
				</td>
				<td>
					<a href="<c:url value="/deleteprocedure/${procedure.getProcedureId()}"/>"> 
    				delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<a href = "/procedures">BACK</a>

</body>
</html>