<%@ page errorPage="jsps/error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Foodie Delights</title>
</head>
<body>
	<p>Hello, Click the below link to get 80% discount!</p>
	<br>
	<% throw new ArithmeticException("Prank!");	%>
</body>
</html>