<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT WORKER INFO</title>

<link rel = "stylesheet" href = '<c:url value = "/resources/css/MainStyle.css"/>' 
type="text/css"/>

</head>
<body>

	<c:url value="/editworker" var="worker"/>
	
	<spring_form:form action="${worker}" method="post" modelAttribute="newWorker">
	
	<spring_form:hidden path="userid" value = "${newWorker.userid}"/>
	
	<spring_form:label path="name">NAME:</spring_form:label>
    <spring_form:input type="text" path="name"/><br>
    
    <spring_form:label path="surname">SURNAME:</spring_form:label>
    <spring_form:input type="text" path="surname"/><br>
    
    <spring_form:label path="login">LOGIN:</spring_form:label>
    <spring_form:input type="text" path="login"/><br>
    
    <spring_form:label path="password">PASSWORD:</spring_form:label>
    <spring_form:input type="text" path="password"/><br>
    
    <label for = "roleid">ROLE</label>
    <datalist id = "rolelist">
    	<c:forEach items = "${roles}" var = "role">
    		<option value = "${role.getRoleId()}"> - ${role.getName()}
    	</c:forEach>
    </datalist>
    <input type="number" name="roleid" id = "roleid" list="rolelist">
    
    <label for = "departmentid">DEPARTMENT</label>
    <datalist id = "deptlist">
    	<c:forEach items = "${departments}" var = "dept">
    		<option value = "${dept.getId()}"> - ${dept.getName()}
    	</c:forEach>
    </datalist>
    <input type = "number" id = "departmentid" name = "departmentid" list = "deptlist">
    
    <input type="submit" value="Submit">
	
	</spring_form:form>

</body>
</html>