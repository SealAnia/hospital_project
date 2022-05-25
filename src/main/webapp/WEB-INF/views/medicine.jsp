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
<title>MEDICINES</title>
</head>
<body>
	<div>
		<h4>MEDICINES LIST</h4>
	</div>
	<div>
		<c:forEach items = "${medicines}" var = "medicine">
			<c:out value = "${medicine.getMedicineId()}"/>
			<c:out value = "${medicine.getName()}"/>
			<c:out value = "${medicine.getNumberPerDay()}"/>
		</c:forEach>
	</div>
</body>
</html>