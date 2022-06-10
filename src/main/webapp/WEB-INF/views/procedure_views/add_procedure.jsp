<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW PROCEDURE</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/procedures" var="procedure"/>
	
	<spring_form:form action="${procedure}" method="post" modelAttribute="procedure">
    <spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="name" path="name"/><br>
    <spring_form:label path="date">DATE:</spring_form:label>
    <spring_form:input type="date" path="date"/><br>
    <spring_form:label path="details">COMMENTS:</spring_form:label>
    <spring_form:input type="text" path="details"/><br>
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>