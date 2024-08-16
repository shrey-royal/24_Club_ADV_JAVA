<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.dao.ProductDao" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Product</title>
    <!-- Materialize CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
    <!-- Google Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Materialize JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <style>
        body {
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="center-align">Edit Product</h1>
        <% 
            ProductBean pro = new ProductDao().getProductById(Integer.parseInt(request.getParameter("id")));
        	request.setAttribute("product", pro);
        %>
        <form action="/E_commerce/products" method="post" enctype="multipart/form-data">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="product_id" value="${product.getProductId()}" />
            
            <div class="input-field">
                <input id="product_name" type="text" name="product_name" value="${product.getProductName()}" required />
                <label for="product_name">Name</label>
            </div>
            
            <div class="input-field">
                <textarea id="product_description" name="product_description" class="materialize-textarea" required>${product.getProductDescription()}</textarea>
                <label for="product_description">Description</label>
            </div>
            
            <div class="input-field">
                <input id="product_price" type="number" name="product_price" step="0.01" value="${product.getProductPrice()}" required />
                <label for="product_price">Price</label>
            </div>
            
            <img src="/E_commerce/image?id=${product.getProductId()}" alt="Product Image" style="width: 100px; height: auto;" />
            <div class="file-field input-field">
                <div class="btn">
                    <span>Image</span>
                    <input type="file" id="image" name="image" />
                </div>
                <div class="file-path-wrapper">
                    <input class="file-path validate" type="text" placeholder="Upload an image" />
                </div>
            </div>
            
            <button class="btn waves-effect waves-light" type="submit">Update Product
                <i class="material-icons right">send</i>
            </button>
        </form>
    </div>
    <script>
        // Initialize Materialize components
        M.AutoInit();
    </script>
</body>
</html>

