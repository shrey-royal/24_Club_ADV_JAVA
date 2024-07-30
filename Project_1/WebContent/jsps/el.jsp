<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expression Language</title>
</head>
<body>
	<!-- <form action="el1.jsp">
		<input type="text" name="name">
		<br>
		<input type="submit">
	</form>
	 -->
	 
	 <%
	 	//session.setAttribute("afterLife", "PRANK!, You are in HELL");
	 	Cookie cook = new Cookie("password", "shakalakaboomboom");
	 	response.addCookie(cook);
	 
	 %>
	 <a href="el1.jsp">Click Here to go to the heaven</a>
</body>
</html>