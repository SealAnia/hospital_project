<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW WORKER</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/workers" var="worker"/>
	
	<spring_form:form action="${worker}" method="post" modelAttribute="worker">
	
	<spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="text" path="name"/><br>
    
    <spring_form:label path="surname">SURNAME:</spring_form:label>
    <spring_form:input type="text" path="surname"/><br>
    
    <spring_form:label path="login">LOGIN:</spring_form:label>
    <spring_form:input type="text" path="login"/><br>
    
    <spring_form:label path="password">PASSWORD:</spring_form:label>
    <spring_form:input type="text" path="password"/><br>
    
    <!-- 
    <spring_form:label path="departmentid">DEPARTMENT ID:</spring_form:label>
    <spring_form:input type="number" path="departmentid"/><br>
     -->
    
    <label for = "roleid">ROLE</label>
    <input type = "number" id = "roleid" name = "roleid"/>
    
    <label for = "departmentid">DEPT ID</label>
    <input type = "number" id = "departmentid" name = "departmentid"/>
    
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>