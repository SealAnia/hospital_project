<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PATIENT MEDICAL CARD</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	${patient.name} ${patient.surname} started treating in the hospital on 
	${patient.admission} at the ${patient.getDepartment().getName()}.
	<c:if test="${patient.release != null}">
	Treating was finished on ${patient.release}.
	</c:if>
	<br>
	
	Operations:
	<br>
	<c:forEach items = "${patient.getOperations()}" var = "operation">
		<ul>
			<li>${operation.date}</li>
		</ul>
	</c:forEach>
	<br>
	
	Procedures:
	<br>
	<c:forEach items = "${patient.getProcedures()}" var = "procedure">
		<ul>
			<li>${procedure.date}</li>
		</ul>
	</c:forEach>
	<br>
	
	Prescribed medicines:
	<br>
	<c:forEach items = "${patient.getMedicines()}" var = "medicine">
		<ul>
			<li>${medicine.name}</li>
		</ul>
	</c:forEach>
	<br>

</body>
</html>