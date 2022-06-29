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

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

<script src="<c:url value="/resources/js/delete_department_alert.js" var = "OKAlert" />"></script>

</head>
<body>
	<c:url value="/deletedepartment/${department.getId()}" var="department"/>
	
	<script src="${OKAlert}"></script>
	
</body>
</html>