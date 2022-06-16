<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:url value="/patients" var="prescription"/>
	
	<form action="${prescription}" method="post" modelAttribute="prescription">
	
    <!-- 
    <spring_form:label path="departmentid">DEPARTMENT ID:</spring_form:label>
    <spring_form:input type="number" path="departmentid"/><br>
     -->
    
    <label for = "medicineid">MEDICINE ID</label>
    <input type = "number" id = "medicineid" name = "medicineid"/>
    
    <label for = "patientid">PATIENT ID</label>
    <input type = "number" id = "patientid" name = "patientid"/>
    
    <input type="submit" value="Submit">
	</form>

</body>
</html>