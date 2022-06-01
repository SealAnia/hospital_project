<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE DEPARTMENT</title>

<script src="<c:url value="/resources/js/ok_alert.js" var = "OKAlert" />"></script>

</head>
<body>
	<c:url value="/deletedepartment/${department.getId()}" var="department"/>
	
	<script src="${OKAlert}"></script>
	
	Department is deleted
	<a href="<c:url value="/departments"/>"> OK </a>

</body>
</html>