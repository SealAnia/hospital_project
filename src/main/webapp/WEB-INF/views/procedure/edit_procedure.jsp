<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE PROCEDURE INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/edit_procedure" var="procedure"/>
	
	<spring_form:form action="${procedure}" method="post" modelAttribute="newProcedure">
	
	<!-- <spring_form:hidden path="procedureid" value = "${newProcedure.getProcedureid()}"/>
	 -->
	
	<spring_form:hidden path="procedureid" value = "${newProcedure.procedureid}"/>
	
    <spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="name" path="name"/><br>
    
    <spring_form:label path="date">DATE:</spring_form:label>
    <spring_form:input type="date" path="date"/><br>
    
    <label for = "patientid">PATIENT</label>
    <datalist id = "patientlist">
    	<c:forEach items = "${patients}" var = "patient">
    		<option value = "${patient.prescription}"> - ${patient.getName()}
    	</c:forEach>
    </datalist>
    <input type="number" name="patientid" id = "patientid" list="patientlist">
    
    <spring_form:label path="details">COMMENTS:</spring_form:label>
    <spring_form:input type="text" path="details"/><br>
    
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>