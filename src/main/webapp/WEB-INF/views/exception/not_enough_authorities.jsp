<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ACCESS DENIED PAGE</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/AccessDeniedStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<b>YOU DONT HAVE ENOUGH AUTHORITIES TO ACCESS THIS PAGE!</b>
	<br>
	<a href = "/main">Back to Main Page</a>

</body>
</html>