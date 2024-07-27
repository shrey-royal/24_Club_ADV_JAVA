<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ActionElements</title>
</head>
<body>
	<jsp:include page="ActionElements2.jsp" />
	<br><br><br>
	<jsp:useBean id="calc" scope="page" class="calc.MyCalculator" />
	<% out.print(calc.cube(11)); %>
</body>
</html>