<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Cars</title>

<!-- Add Bootstrap CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<!-- Add DataTables CSS -->
<link href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css" rel="stylesheet">

<!-- Add jQuery (required by DataTables) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- Add DataTables JavaScript -->
<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
	<center>
		<h1>Car Showroom</h1>
		<h2>
			<a href="/First_MVC_App/views/InsertCar.html">InsertCar</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/First_MVC_App/listall">List All Cars</a>
		</h2>
	</center>
	
	<caption><h1 align=center>List of Cars</h1></caption>
	<table id='carTable' class='table table-striped table-bordered'>
		<thead>
			<tr>
				<th>Id</th>
				<th>Make</th>
				<th>Model</th>
				<th>Year</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="car" items="${ cars }">
				<tr>
					<td><c:out value="${car.id }"/></td>
					<td><c:out value="${car.make }"/></td>
					<td><c:out value="${car.year }"/></td>
					<td><c:out value="${car.model }"/></td>
					<td><c:out value="${car.price }"/></td>
					<td>
						<a href="edit?id=<c:out value='${car.id}'/>">Edit</a>
						&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
						<a href="delete?id=<c:out value='${car.id}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
            </tbody>
	</table>
	
	
	<script>
        $(document).ready(function() {
            $('#carTable').DataTable();
        });
    </script>
</body>
</html>