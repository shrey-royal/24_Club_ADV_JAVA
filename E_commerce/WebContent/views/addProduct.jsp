<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
	<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #111;
            text-align: center;
            margin: 20px 0;
        }

        .container {
            width: 80%;
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        textarea,
        input[type="number"],
        input[type="image"] {
            width: 40%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 40%;
            background-color: #f0c14b;
            border: 1px solid #a88734;
            color: #111;
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #e2a528;
        }
    </style>
</head>
<body>
	<h1>Add New Product</h1>
	<form action="products" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="add" />
        <label for="product_name">Name:</label>
        <input type="text" id="product_name" name="product_name" required /><br />
        <label for="product_description">Description:</label>
        <textarea id="product_description" name="product_description" required></textarea><br />
        <label for="product_price">Price:</label>
        <input type="number" id="product_price" name="product_price" step="0.01" required /><br />
        <label for="image">Image:</label>
        <input type="file" id="image" name="image" /><br />
        <input type="submit" value="Add Product" />
    </form>
</body>
</html>