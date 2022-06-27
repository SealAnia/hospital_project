<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUTHORIZE</title>
</head>
<body>

	<div>
      <form method="post" action="/login">
        <h2>Please sign in</h2>
        <p>
          <label for="username">Username</label>
          <input type="text" id="username" name="username" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password">Password</label>
          <input type="password" id="password" name="password" placeholder="Password" required>
        </p>
		
        <button type="submit">Sign in</button>
      </form>
      </div>
      
</body>
</html>