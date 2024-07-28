<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>
    
    <jsp:useBean id="user" class="calc.User" scope="session" />
    <jsp:setProperty name="user" property="username" value="dhyey" />
    <jsp:setProperty name="user" property="email" value="dhyey@google.org" />
    <jsp:setProperty name="user" property="age" value="30" />
    
    <p>Username: <jsp:getProperty name="user" property="username" /></p>
    <p>Email: <jsp:getProperty name="user" property="email" /></p>
    <p>Age: <jsp:getProperty name="user" property="age" /></p>

    <form action="updateProfile.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" value="<jsp:getProperty name='user' property='username' />" /><br />
        
        <label for="email">Email:</label>
        <input type="text" name="email" value="<jsp:getProperty name='user' property='email' />" /><br />
        
        <label for="age">Age:</label>
        <input type="text" name="age" value="<jsp:getProperty name='user' property='age' />" /><br />
        
        <input type="submit" value="Update Profile" />
    </form>
</body>
</html>
