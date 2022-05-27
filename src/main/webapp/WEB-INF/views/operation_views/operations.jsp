<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.hospital.controller.DepartmentController" %>
<%@ page import="com.example.hospital.model.entity.Department" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OPERATIONS</title>
</head>
<body>
	<div>
		<h4>OPERATIONS LIST</h4>
	</div>
	<div>
		<c:forEach items = "${operations}" var = "operation">
			<c:out value = "${operation.getId()}"/>
			<c:out value = "${operation.getDate()}"/>
			<c:out value = "${operation.getComments()}"/>
		</c:forEach>
	</div>
</body>
</html>