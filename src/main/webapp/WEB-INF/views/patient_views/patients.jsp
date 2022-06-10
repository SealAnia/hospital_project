<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PATIENTS</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>
	<body>
	<div>
		<h4>PATIETNS</h4>
	</div>
	
	<div>
		<form action = "/patients/searchresults" method = "get">
			<p><input type="text" name = "keyword" placeholder = "Search on page">
			<input type="submit" value="SEARCH">
			</p>
		</form>
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
			<c:forEach items = "${patients}" var = "patient">
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
    				medical card</a>
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
		<form action = "/patients/sortedby/surname/asc">
			<button>SORT BY SURNAME ASCENDING</button>
		</form>
		<form action = "/patients/sortedby/surname/desc">
			<button>SORT BY SURNAME DESCENDING</button>
		</form>
		
		<form action = "/patients/sortedby/name/asc">
			<button>SORT BY NAME ASCENDING</button>
		</form>
		<form action = "/patients/sortedby/name/desc">
			<button>SORT BY NAME DESCENDING</button>
		</form>
		
		<form action = "/patients/sortedby/diagnosis/asc">
			<button>SORT BY DIAGNOSIS ASCENDING</button>
		</form>
		<form action = "/patients/sortedby/diagnosis/desc">
			<button>SORT BY DIAGNOSIS DESCENDING</button>
		</form>
		
		<form action = "/patients/sortedby/admission/asc">
			<button>SORT BY ADMISSION ASCENDING</button>
		</form>
		<form action = "/patients/sortedby/admission/desc">
			<button>SORT BY ADMISSION DESCENDING</button>
		</form>
		
		<form action = "/patients/sortedby/release/asc">
			<button>SORT BY RELEASE ASCENDING</button>
		</form>
		<form action = "/patients/sortedby/release/desc">
			<button>SORT BY RELEASE DESCENDING</button>
		</form>
		
		<form action = "/patients/sortedby/department/asc">
			<button>SORT BY DEPARTMENT ASCENDING</button>
		</form>
		<form action = "/patients/sortedby/department/desc">
			<button>SORT BY DEPARTMENT DESCENDING</button>
		</form>
		
		<form action = "/patients">
			<button>REVERT</button>
		</form>
	</div>
	
	<div>
		<p>
			<a href="<c:url value="/showpatientform"/>"> Add new Patient</a>
		</p>
		<p>
			<a href="<c:url value="/main"/>"> Back to Main Menu</a>
		</p>
	</div>
	
</body>
</body>
</html>