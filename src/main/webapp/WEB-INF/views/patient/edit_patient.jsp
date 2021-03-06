<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE PATIENT INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	
	<c:url value="/editpatient" var="patient"/>
	
	<spring_form:form action="${patient}" method="post" modelAttribute="newPatient"
	class = "edition">
	
	<spring_form:hidden path="patientid" value = "${newPatient.patientid}"/>
	
	<spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="text" path="name"/><br>
    
    <spring_form:label path="surname">SURNAME:</spring_form:label>
    <spring_form:input type="text" path="surname"/><br>
    
    <spring_form:label path="diagnosis">DIAGNOSIS:</spring_form:label>
    <spring_form:input type="text" path="diagnosis"/><br>
    
    <spring_form:label path="admission">ADMISSION:</spring_form:label>
    <spring_form:input type="date" path="admission"/><br>
    
    <spring_form:label path="release">RELEASE:</spring_form:label>
    <spring_form:input type="date" path="release"/><br>
    
    <label for = "departmentid">DEPARTMENT</label>
    <datalist id = "departmentlist">
    	<c:forEach items = "${departments}" var = "department">
    		<option value = "${department.getId()}"> - ${department.getName()}
    	</c:forEach>
    </datalist>
    <input type = "number" id = "departmentid" name = "departmentid" list = "departmentlist">
    </br>
    
    <label for="comments">COMMENTS:</label>
    <textarea rows="10" cols="20" id = "comments" name = "comments">
    WRITE COMMENTS
    </textarea>
    <br>
    
    <spring_form:label path="result">RESULT:</spring_form:label>
    <spring_form:input type="text" path="result"/><br>
    
    <input type="submit" value="Submit">
	</spring_form:form>
	
</body>
</html>