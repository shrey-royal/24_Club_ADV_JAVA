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
    <style type="text/css">
    	body {
            font-family: 'Roboto', sans-serif;
            background-color: #121212;
            color: #e0e0e0;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #1e1e1e;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 100%;
            max-width: 360px;
        }
        h1 {
            margin-bottom: 20px;
            color: #2196F3;
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
        }
        input[type="text"],
		input[type="email"],
        input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #333;
            border-radius: 4px;
            background-color: #424242;
            color: #e0e0e0;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #2196F3;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0d47a1;
        }
        a {
        	color: #2196F3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="/E_commerce/login" method="post">
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
