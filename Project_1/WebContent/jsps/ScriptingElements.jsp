<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scripting Elements</title>
</head>
<body>
	Declaration Tag: <%! int randomNumber = 0; %>
	<br>
	Scriptlet Tag: <% randomNumber = (int)(Math.random()*100); %>
	<br>
	Expression Tag: <p>Random Number: <%= randomNumber %></p>
	<br>
</body>
</html>