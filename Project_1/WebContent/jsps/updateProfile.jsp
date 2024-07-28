<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
</head>
<body>
    <h1>Update Profile</h1>
    
    <jsp:useBean id="user" class="calc.User" scope="session" />
    <jsp:setProperty name="user" property="username" />
    <jsp:setProperty name="user" property="email" />
    <jsp:setProperty name="user" property="age" />

	<p>Username: <jsp:getProperty name="user" property="username" /></p>
    <p>Email: <jsp:getProperty name="user" property="email" /></p>
    <p>Age: <jsp:getProperty name="user" property="age" /></p>

    
</body>
</html>
