<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required placeholder="Enter your username" />
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required placeholder="Enter your password" />
            
            <input type="submit" value="Login" />
		</form>
        <p>Don't have an account? <a href="Register.html">Register Here</a></p>
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>
    </div>
</body>
</html>
