<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page 1</title>
</head>
<body>
	<h1>Welcome to the world of JSP!</h1>
	<br>
	<strong>Current Time is <% out.print(Calendar.getInstance().getTime()); %></strong>	
</body>
</html>