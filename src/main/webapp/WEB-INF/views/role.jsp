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
<title>WORKERS BY ROLE</title>
</head>
<body>
	<div>
		<h4>WORKERS BY ROLE</h4>
	</div>
	<div>
		<c:forEach items = "${roles}" var = "role">
			<c:out value = "${role.getRoleId()}"/>
			<c:out value = "${role.getName()}"/>
		</c:forEach>
	</div>
</body>
</html>