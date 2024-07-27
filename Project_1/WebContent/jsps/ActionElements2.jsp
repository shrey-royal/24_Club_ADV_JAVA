<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ActionElements2</title>
</head>
<body>
	<% out.print(Calendar.getInstance().getTime()); %>
</body>
</html>