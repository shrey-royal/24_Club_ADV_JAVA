<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Products</title>

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
    <div class="container mt-5">
        <a href="views/addProduct.jsp" class="btn btn-primary mb-3">Add New Product</a>
        <h1 class="text-center mb-4">Product List</h1>
        <table id="productTable" class="text-center table table-striped table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th class="text-center">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td><c:out value="${product.productId}"/></td>
                        <td><c:out value="${product.productName}"/></td>
                        <td><c:out value="${product.productDescription}"/></td>
                        <td><c:out value="${product.productPrice}"/></td>
                        <td>
                            <img src="image?id=${product.productId}" alt="Product Image" style="width: 100px; height: auto;" />
                        </td>
                        <td class="d-flex justify-content-around text-center">
                            <a href="products?action=view&id=${product.productId}" class="ml-1 btn btn-info btn-sm">View</a>
                            <a href="views/editProduct.jsp?id=${product.productId}" class="ml-1 btn btn-warning btn-sm">Edit</a>
                            <a href="products?action=delete&product_id=${product.productId}" class="ml-1 btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script>
        $(document).ready(function() {
            $('#productTable').DataTable();
        });
    </script>
</body>
</html>