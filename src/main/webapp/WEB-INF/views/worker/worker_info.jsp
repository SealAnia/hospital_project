<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WORKER INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	${user.name} ${user.surname} is a ${user.getRole().getName().substring(5).toLowerCase()} at a ${user.getDept().getName()}<br>
	PRESCRIBED MEDICINES: 
	<c:forEach items = "${user.getMedicines()}" var = "medicine">
		<ul>
			<li>${medicine.getName()} ${medicine.getPatient().getName()} 
			${medicine.getPatient().getSurname()} ${medicine.getPatient().getDepartment().getName()}</li>
		</ul>
	</c:forEach>
	<br>
	PROCEDURES: 
	<c:forEach items = "${user.getProcedures()}" var = "procedure">
		<ul>
			<li>${procedure.getName()} ${procedure.getDate()} ${procedure.getPatient().getName()} 
			${procedure.getPatient().getSurname()} ${procedure.getPatient().getDepartment().getName()}</li>
		</ul>
	</c:forEach>
	<br>
	OPERATIONS: 
	<c:forEach items = "${user.getOperations()}" var = "operation">
		<ul>
			<li>${operation.getDate()} ${operation.getPatient().getName()} 
			${operation.getPatient().getSurname()} ${operation.getPatient().getDepartment().getName()}</li>
		</ul>
	</c:forEach>
	
</body>
</html>