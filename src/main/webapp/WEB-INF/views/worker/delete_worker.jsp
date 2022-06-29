<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE WORKER INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

<script src="<c:url value="/resources/js/delete_worker_alert.js" var = "OKAlert" />"></script>

</head>
<body>

	<c:url value="/deleteworkerinfo/${worker.userid}" var="worker"/>
	
	<script src="${OKAlert}"></script>
	
</body>
</html>