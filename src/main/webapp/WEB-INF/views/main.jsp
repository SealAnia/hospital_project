<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAIN PAGE</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	<div><h1>WELCOME TO YOUR WEB HOSPITAL HELPER</h1></div>
		<div>
			<p><a href = "/departments"> All Departments </a></p>
			<p><a href = "/medicines"> Medicines Info </a></p>
			<p><a href = "/procedures"> Procedures Info </a></p>
			<p><a href = "/operations"> Operations Info </a></p>
			<p><a href = "/roles"> Hospital Stuff </a></p>
			<p><a href = "/patients"> Patients </a></p>
		</div>
</body>
</html>