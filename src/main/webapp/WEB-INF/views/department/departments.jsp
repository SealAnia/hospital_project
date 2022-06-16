<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DEPARTMENTS</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	<div>
		<h4>HOSPITAL DEPARTMENTS</h4>
	</div>
	
	<div>
		<form action = "/departments/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
		<table>
			<tr>
				<th>ID</th>
				<th>Department name</th>
			</tr>
			<c:forEach items = "${departments}" var = "department">
			<tr>
				<td>
    				<a href="<c:url value="/departments/${department.getId()}"/>">
    				${department.id}</a>
				</td>
				<td>
					${department.name}
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
		<form action = "/departments/sortedby/name/asc">
			<button>SORT BY NAME ASCENDING</button>
		</form>
		<form action = "/departments/sortedby/name/desc">
			<button>SORT BY NAME DESCENDING</button>
		</form>
		<form action = "/departments">
			<button>REVERT</button>
		</form>
	</div>
	
	<div>
		<form action = "/showdepartmentform">
			<button>Add new Department</button>
		</form>
		<form action = "/main">
			<button>Back to Main Menu</button>
		</form>
	</div>
	
</body>
</html>