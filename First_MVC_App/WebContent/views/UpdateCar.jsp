<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
<style>
	.center-form {
		justify-content: center;
		display: flex;
		margin: auto;
		margin-top: 50px;
		border: 3px solid blue;
		padding: 30px;
		background-color: rgb(208, 205, 248);
		width: 50%;
	}
</style>
</head>
<body>
	<center>
		<h1>Car Showroom</h1>
		<h2>
			<a href="InsertCar.html">Insert Car</a>
			&nbsp;&nbsp;&nbsp;
			<a href="listall">List All Cars</a>
		</h2>
	</center>
	<h1 align="center">Add New Car</h1>
	<div class="center-form">
		<form action="update" method="post">
		
			<input type="hidden" name="id" value="${carBean.id }"/>
			
			<label for="make">Make: </label>
			<input type="text" name="make" placeholder="enter company name" value="${ carBean.make }"/>
			<br><br>
			
			<label for="model">Model: </label>
			<input type="text" name="model" placeholder="enter car model" value="${ carBean.model }"/>
			<br><br>
			
			<label for="year">Year: </label>
			<input type="number" name="year" placeholder="enter year of manufacturing" value="${ carBean.year }"/>
			<br><br>
			
			<label for="price">Price: </label>
			<input type="number" name="price" placeholder="enter car price" value="${ carBean.price }"/>
			<br><br>
			
			<input type="submit" value="Update Car Details"/>	
			
		</form>
	</div>
</body>
</html>