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
	
	<div class = "left">
		<form action = "/procedures/sortedbydatediaposon" method = "get">
			<input type="date" name = "dateFirst">
			<input type="date" name = "dateSecond">
			<input type="submit" value = "FIND PROCEDURES IN DATE DIAPOSON">
		</form>
		<form action = "/procedures/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Patient</th>
				<th>Who did</th>
				<th>Instruction</th>
				<th>Date</th>
			</tr>
			<c:forEach items = "${procedures}" var = "procedure">
			<tr>
				<td>
					<a href="<c:url value="/procedures/${procedure.getProcedureId()}"/>">
					${procedure.getProcedureId()}</a>
				</td>
				<td>
					${procedure.getName()}
				</td>
				<td>
					${procedure.getPatient().getName()} ${procedure.getPatient().getSurname()}
				</td>
				<td>
					${procedure.getUser().getName()} ${procedure.getUser().getSurname()}
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
	
	<div class = "right">
		<form action = "/procedures/sortedby/name/asc">
			<button>SORT BY NAME ASCENDING</button>
		</form>
		<form action = "/procedures/sortedby/name/desc">
			<button>SORT BY NAME DESCENDING</button>
		</form>
		<form action = "/procedures/sortedby/date/asc">
			<button>SORT BY DATE ASCENDING</button>
		</form>
		<form action = "/procedures/sortedby/date/desc">
			<button>SORT BY DATE DESCENDING</button>
		</form>
		<form action = "/procedures">
			<button>REVERT</button>
		</form>	
		
		<form action = "/showprocedureform">
			<button>Add new Procedure</button>
		</form>
		<form action = "/main">
			<button>Back to Main Menu</button>
		</form>
	</div>
</body>
</html>