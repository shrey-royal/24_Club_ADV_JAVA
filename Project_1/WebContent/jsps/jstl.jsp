<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL</title>
</head>
<body>
	<c:out value="Hello Hello!"/>
	<c:if test="${ 1>0 }">
		<c:out value="I'm in IF"/>
	</c:if>
	
	<c:forEach var="i" begin="0" end="20">
		Item <c:out value="${i}"/>
		<c:if test="${ i%5 == 0 }">
			<br>
		</c:if>
	</c:forEach>
</body>
</html>