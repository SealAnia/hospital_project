<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRESCRIBE MEDICINE</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/prescriptions" var="prescription"/>
	
	<spring_form:form action="${prescription}" method="post" modelAttribute="prescription">
	
    <label for = "patientid">PATIENT</label>
    <datalist id = "patientlist">
    	<c:forEach items = "${patients}" var = "patient">
    		<option value = "${patient.patientid}"> - ${patient.getName()}
    	</c:forEach>
    </datalist>
    <input type="number" name="patientid" id = "patientid" list="patientlist">
    
    <label for = "medicineid">MEDICINE</label>
    <datalist id = "medicinelist">
    	<c:forEach items = "${medicines}" var = "medicine">
    		<option value = "${medicine.getId()}"> - ${medicine.getName()}
    	</c:forEach>
    </datalist>
    <input type = "number" id = "medicineid" name = "medicineid" list = "medicinelist">
    
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>