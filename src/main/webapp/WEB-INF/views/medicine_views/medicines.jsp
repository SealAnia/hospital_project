<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MEDICINES</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>

<body>
<body>
	<div>
		<h4>MEDICINES LIST</h4>
	</div>
	
	<div>
		<form action = "/medicines/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
		<table>
			<tr>
				<th>ID</th>
				<th>Medicine</th>
				<th>Frequency</th>
			</tr>
			<c:forEach items = "${medicines}" var = "medicine">
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
	
	<div>
		<form action = "/medicines/sorted/byname/asc">
			<button>SORT BY NAME ASCENDING</button>
		</form>
		<form action = "/medicines/sorted/byname/desc">
			<button>SORT BY NAME DESCENDING</button>
		</form>
		<form action = "/medicines">
			<button>REVERT</button>
		</form>
	</div>
	
	<div>
		<p>
			<a href="<c:url value="/showmedicineform"/>"> Add new Medicine</a>
		</p>
		<p>
			<a href="<c:url value="/main"/>"> Back to Main Menu</a>
		</p>
	</div>
	
</body>
</html>