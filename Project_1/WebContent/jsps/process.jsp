<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="u" class="calc.User" scope="request"></jsp:useBean>
<jsp:setProperty property="name" name='u'/><br>
<jsp:setProperty property="email" name='u'/><br>
<jsp:setProperty property="password" name='u'/><br>

Record: <br>
<jsp:getProperty property="name" name='u'/><br>
<jsp:getProperty property="email" name='u'/><br>
<jsp:getProperty property="password" name='u'/><br>