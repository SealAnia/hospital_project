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

	${user.name} ${user.surname} is a ${user.getRole().getName()} at a ${user.getDept().getName()}<br>
	MEDICINES: 
	<c:forEach items = "${user.getMedicines()}" var = "medicine">
		${medicine.getName()} 
			<c:forEach items = "${medicine.getPatients()}" var = "patient">
				${patient.getName()} ${patient.getSurname()} ${patient.getDepartment().getName()}
			</c:forEach>
	</c:forEach>
	PROCEDURES: 
	<c:forEach items = "${user.getProcedures()}" var = "procedure">
		${procedure.getName()} ${procedure.getDate()} ${procedure.getPatient().getName()} 
		${procedure.getPatient().getSurname()} ${procedure.getPatient().getDepartment().getName()} 
	</c:forEach>
	OPERATIONS: 
	<c:forEach items = "${user.getOperations()}" var = "operation">
		${operation.getDate()} ${operation.getPatient().getName()} 
		${operation.getPatient().getSurname()} ${operation.getPatient().getDepartment().getName()} 
	</c:forEach>
	
</body>
</html>