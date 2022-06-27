<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN PAGE</title>
</head>
<body>
	
	<form action = "/departments">
		<button>View All Departments</button>
	</form>
	
	<form action = "/showdepartmentform">
		<button>Add new Department</button>
	</form>
	
	<form action = "/workers/page1">
		<button>View All Workers</button>
	</form>
	
	<form action = "/showworkerform">
		<button>Add new Worker</button>
	</form>

</body>
</html>