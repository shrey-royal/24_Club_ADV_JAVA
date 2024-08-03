<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="a" uri="/WEB-INF/myTag.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Tags</title>
<style>
	.badge {
	    padding: 5px 10px;
	    border-radius: 5px;
	    color: white;
	    font-weight: bold;
	}
	
	.badge-save-big {
	    background-color: green;
	}
	
	.badge-great {
	    background-color: blue;
	}
	
	.badge-unbelievable {
	    background-color: orange;
	}
	
	.badge-insane {
	    background-color: red;
	}
	
	.price {
		color: grey;
		font-size: 20px;
		text-decoration: bold;
	}
</style>
</head>
<body>
	<a:today />
	<a:greet username="abcd" />
	
	<div>
		<h1>Product Name: </h1>
		<p>Price: <span class='price'>$100</span></p>
		
		<a:discountBadge discount="40"/>
	</div>
</body>
</html>