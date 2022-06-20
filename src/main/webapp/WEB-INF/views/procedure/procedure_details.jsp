<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROCEDURE DETAILS</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	${procedure.name} ${procedure.date} ${procedure.getPatient().getName()} 
	${procedure.getPatient().getSurname()} ${procedure.getPatient().getDepartment().getName()} 
	${procedure.details}

</body>
</html>