<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW OPERATION</title>
</head>
<body>

	<c:url value="/operations" var="operation"/>
	
	<spring_form:form action="${operation}" method="post" modelAttribute="operation">
    <spring_form:label path="date">DATE:</spring_form:label>
    <spring_form:input type="date" path="date"/><br>
    <spring_form:label path="comments">COMMENTS:</spring_form:label>
    <spring_form:input type="text" path="comments"/><br>
    <input type="submit" value="Submit">
	</spring_form:form>

</body>
</html>