<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DOCTORS AND NURSES</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	<div>
		<h4>HOSPITAL STUFF</h4>
	</div>
	
	<div class = "left">
		<form action = "/workers/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Role</th>
				<th>Department</th>
			</tr>
			<c:forEach items = "${users}" var = "worker">
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
					<a href="<c:url value="/worker?userid=${worker.getUserId()}"/>"> 
    				view details</a>
				</td>
				<td>
					<a href="<c:url value="/showeditworker/${worker.getUserId()}"/>">
    				edit</a>
				</td>
				<td>
					<a href="<c:url value="/deleteworkerinfo/${worker.getUserId()}"/>"> 
    				delete</a>
				</td>
			</tr>
		</c:forEach>
		</table>
		<p>
			<c:if test="${number > 1}">
			<a href = "/workers/page${number - 1}"> ${number - 1} </a>
			</c:if>
			${number} 
			<a href = "/workers/page${number + 1}"> ${number + 1} </a>
		</p>
	</div>
	
	<div class = "right">
		
		<form action = "/workers/sortedby/surname/asc">
			<button>SORT BY SURNAME ASCENDING</button>
		</form>
		<form action = "/workers/sortedby/surname/desc">
			<button>SORT BY SURNAME DESCENDING</button>
		</form>
		
		<form action = "/workers/sortedby/name/asc">
			<button>SORT BY NAME ASCENDING</button>
		</form>
		<form action = "/workers/sortedby/name/desc">
			<button>SORT BY NAME DESCENDING</button>
		</form>
		
		<form action = "/workers/sortedby/role/asc">
			<button>SORT BY ROLE ASCENDING</button>
		</form>
		<form action = "/workers/sortedby/role/desc">
			<button>SORT BY ROLE DESCENDING</button>
		</form>
		
		<form action = "/workers/sortedby/department/asc">
			<button>SORT BY DEPARTMENT ASCENDING</button>
		</form>
		<form action = "/workers/sortedby/department/desc">
			<button>SORT BY DEPARTMENT DESCENDING</button>
		</form>
		
		<form action = "/workers/page1">
			<button>REVERT</button>
		</form>
		
		<form action = "/roles">
			<button>Find Workers by Role</button>
		</form>
		<form action = "/showworkerform">
			<button>Add New Worker</button>
		</form>
		<form action = "/main">
			<button>Back to Main Menu</button>
		</form>
	</div>
</body>
</html>