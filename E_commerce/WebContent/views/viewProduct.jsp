<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Product</title>
    <!-- Import Materialize CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
    <!-- Import Google Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: center;
            height: 100vh;
            padding: 20px;
            box-sizing: border-box;
        }
        .product-image {
            max-width: 50%;
            height: auto;
            flex: 1;
        }
        .product-details {
            flex: 2;
            padding: 20px;
        }
        .price {
            font-size: 1.5em;
            color: #388e3c; /* Materialize green color for better visibility */
        }
        .container .row {
            width: 100%;
        }
        .center-align {
            text-align: center;
        }
        .back-button {
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav>
        <div class="nav-wrapper teal">
            <a href="#" class="brand-logo center">Product Details</a>
        </div>
    </nav>

    <!-- Main content -->
    <div class="container">
        <img class="product-image" src="image?id=${product.productId}" alt="${product.imageName}">
        <div class="product-details">
            <h4>${product.productName}</h4>
            <p><strong>ID:</strong> ${product.productId}</p>
            <p><strong>Description:</strong> ${product.productDescription}</p>
            <p><strong>Price:</strong> <span class="price">&#8377;${product.productPrice}</span></p>
            <a href="products?action=list" class="btn teal back-button">Back to List</a>
        </div>
    </div>

    <!-- Import Materialize JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <!-- Initialize Materialize components -->
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            M.AutoInit();
        });
    </script>
</body>
</html>
