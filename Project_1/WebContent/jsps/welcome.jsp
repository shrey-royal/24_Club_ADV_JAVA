<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <!-- Material Design Icons -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <!-- Materialize CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
    <style>
        .header {
            background-color: #2196F3; /* Material Design Blue */
            color: white;
            padding: 20px;
            text-align: center;
        }
        .time {
            font-size: 1.2em;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Greetings!</h1>
        <p class="time">
            <%= new SimpleDateFormat("EEEE, MMMM d, yyyy h:mm:ss a").format(new Date()) %>
        </p>
    </div>

    <!-- Materialize JavaScript (optional, if you need it) -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>










<!--
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%/*
		String n = request.getParameter("n");
		String e = request.getParameter("e");
		
		out.print(n + ", " + e);
		*/
	%>
</body>
</html>
-->