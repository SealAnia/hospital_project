<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DEPARTMENT DETAILS</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
<h3>${department.name}</h3>

	Patients
	
	<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Diagnosis</th>
				<th>Admission</th>
				<th>Release</th>
				<th>Comments</th>
			</tr>
		<c:forEach items = "${department.getPatients()}" var = "patient">
			<tr>
				<td><c:out value = "${patient.patientid}"/></td>
				<td><c:out value = "${patient.getName()}"/></td>
				<td><c:out value = "${patient.getSurname()}"/></td>
				<td><c:out value = "${patient.getDiagnosis()}"/></td>
				<td><c:out value = "${patient.getAdmission()}"/></td>
				<td><c:out value = "${patient.getRelease()}"/></td>
				<td><c:out value = "${patient.getComments()}"/></td>
			</tr>
		</c:forEach>
	</table>
	
	Workers
	
	<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Role</th>
			</tr>
		<c:forEach items = "${department.getUsers()}" var = "user">
			<tr>
				<td><c:out value = "${user.userid}"/></td>
				<td><c:out value = "${user.getName()}"/></td>
				<td><c:out value = "${user.getSurname()}"/></td>
				<td><c:out value = "${user.getRole().getName().toLowerCase().substring(5)}"/></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>