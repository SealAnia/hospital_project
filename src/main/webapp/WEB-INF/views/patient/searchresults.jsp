<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SEARCH RESULTS</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Diagnosis</th>
				<th>Admission</th>
				<th>Release</th>
				<th>Department</th>
				<th>Comments</th>
			</tr>
			<c:forEach items = "${results}" var = "patient">
			<tr>
				<td>
					<a href="<c:url value="/patients/${patient.getPatientId()}"/>">
					${patient.getPatientId()}</a>
				</td>
				<td>
					${patient.name}
				</td>
				<td>
					${patient.surname}
				</td>
				<td>
					${patient.diagnosis}
				</td>
				<td>
					${patient.admission}
				</td>
				<td>
					${patient.release}
				</td>
				<td>
					${patient.getDepartment().getName()}
				</td>
				<td>
					${patient.comments}
				</td>
				<td>
					<a href="<c:url value="/patient?id=${patient.getPatientId()}"/>"> 
    				view details</a>
				</td>
				<td>
					<a href="<c:url value="/showeditpatient/${patient.getPatientId()}"/>">
    				edit</a>
				</td>
				<td>
					<a href="<c:url value="/deletepatientinfo/${patient.getPatientId()}"/>"> 
    				delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<div>
		<form action = "/patients">
			<button>BACK</button>
		</form>
	</div>
	
</body>
</html>