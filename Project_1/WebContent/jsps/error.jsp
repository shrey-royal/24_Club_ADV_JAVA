<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found | FoodieDelights</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f8f9fa;
            color: #343a40;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .error-code {
            font-size: 6rem;
            margin: 0;
        }
        .error-message {
            font-size: 1.5rem;
            margin: 0;
        }
        .error-description {
            margin: 20px 0;
            font-size: 1rem;
        }
        .links {
            margin: 20px 0;
        }
        .links a {
            margin: 0 10px;
            text-decoration: none;
            color: #007bff;
        }
        .links a:hover {
            text-decoration: underline;
        }
        .footer {
            margin-top: 20px;
            font-size: 0.8rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="error-code">404</h1>
        <p class="error-message">Page Not Found</p>
        <p class="error-description">Oops! The page you're looking for doesn't exist. It might have been moved or deleted.</p>
        <img src="https://example.com/food-image.jpg" alt="Delicious food" width="300">
        <div class="links">
            <a href="jsps/FoodieDelights.jsp">Go to Homepage</a>
            <a href="#">View Our Menu</a>
            <a href="#">Contact Support</a>
        </div>
        <div class="footer">
            © 2024 FoodieDelights. All rights reserved.
        </div>
    </div>
</body>
</html>
