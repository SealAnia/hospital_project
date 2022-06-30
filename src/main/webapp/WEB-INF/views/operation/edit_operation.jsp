<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE OPERATION INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/editoperation" var="operation"/>
	
	<spring_form:form action="${operation}" method="post" modelAttribute="newOperation">
	
	<spring_form:hidden path="id" value = "${newOperation.getId()}"/>
	
    <spring_form:label path="date">DATE:</spring_form:label>
    <spring_form:input type="date" path="date"/><br>
    
    <label for = "patientid">PATIENT</label>
    <datalist id = "patientlist">
    	<c:forEach items = "${patients}" var = "patient">
    		<option value = "${patient.patientid}"> - ${patient.getName()} - ${patient.getSurname()} - ${patient.getDepartment().getName()}
    	</c:forEach>
    </datalist>
    <input type="number" name="patientid" id = "patientid" list="patientlist">
    
    <spring_form:label path="comments">COMMENTS:</spring_form:label>
    <spring_form:input type="text" path="comments"/><br>
    
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>