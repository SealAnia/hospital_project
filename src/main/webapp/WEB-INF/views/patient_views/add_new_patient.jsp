<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW PATIENT</title>
</head>
<body>

	<c:url value="/patients" var="patient"/>
	
	<spring_form:form action="${patient}" method="post" modelAttribute="patient">
	
	<spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="text" path="name"/><br>
    
    <spring_form:label path="surname">SURNAME:</spring_form:label>
    <spring_form:input type="text" path="surname"/><br>
    
    <spring_form:label path="diagnosis">DIAGNOSIS:</spring_form:label>
    <spring_form:input type="text" path="diagnosis"/><br>
    
    <spring_form:label path="admission">ADMISSION:</spring_form:label>
    <spring_form:input type="date" path="admission"/><br>
    
    <!-- 
    <spring_form:label path="departmentid">DEPARTMENT ID:</spring_form:label>
    <spring_form:input type="number" path="departmentid"/><br>
     -->
    
    <label for = "departmentid">Dept ID</label>
    <input type = "number" id = "departmentid" name = "departmentid"/>
    
    <spring_form:label path="comments">COMMENTS:</spring_form:label>
    <spring_form:input type="text" path="comments"/><br>
    
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>