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
            background-color: #121212;
            color: #e0e0e0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }

        h1 {
            color: #ffffff;
            text-align: center;
            margin-bottom: 20px;
        }

        .container {
            width: 100%;
            max-width: 600px;
            background-color: #1e1e1e;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        form {
            display: flex;
            flex-direction: column;
            width: 100%;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            color: #ffffff;
        }

        input[type="text"],
        textarea,
        input[type="number"],
        input[type="file"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #333;
            border-radius: 4px;
            margin-bottom: 15px;
            box-sizing: border-box;
            background-color: #2c2c2c;
            color: #e0e0e0;
        }

        textarea {
            height: 100px;
            resize: vertical;
            font-family: Arial, sans-serif;
            font-size: 16px;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #6200ea;
            border: 1px solid #3700b3;
            color: #ffffff;
            padding: 12px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #3700b3;
        }
    </style>
</head>
<body>
    <div class="container">
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
            <input type="file" id="image" name="image" accept="image/*" /><br />
            <input type="submit" value="Add Product" />
        </form>
    </div>
</body>
</html>
