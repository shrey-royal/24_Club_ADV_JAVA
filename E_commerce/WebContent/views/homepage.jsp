<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style type="text/css">
		body {
		    font-family: 'Roboto', sans-serif;
		    background-color: #121212; /* Dark background color */
		    color: #e0e0e0; /* Light text color */
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		}
		
		header {
		    display: flex;
		    justify-content: space-between;
		    align-items: center;
		    padding: 15px 20px;
		    background-color: #333333; /* Dark header background */
		    border-bottom: 1px solid #444444; /* Slightly lighter border */
		}
		
		.logo {
		    font-size: 24px;
		    font-weight: bold;
		    color: #ffffff; /* White text color */
		}
		
		.search-bar {
		    flex: 1;
		    margin: 0 20px;
		    padding: 10px;
		    border: none;
		    border-radius: 4px;
		    background-color: #444444; /* Dark input background */
		    color: #ffffff; /* White text color */
		}
		
		.cart-icon {
		    font-size: 18px;
		    color: #ffffff; /* White text color */
		}
		
		.hero img {
		    width: 100%;
		    height: auto;
		    display: block;
		}
		
		.featured-products, .all-products {
		    padding: 20px;
		    display: flex;
		    gap: 20px;
		    flex-wrap: wrap;
		}
		
		.product-card {
		    background: #1e1e1e; /* Dark card background */
		    border: 1px solid #333333; /* Slightly lighter border */
		    border-radius: 8px;
		    overflow: hidden;
		    width: 30%;
		    box-shadow: 0 4px 8px rgba(0,0,0,0.3); /* Materialistic shadow */
		    padding: 15px;
		    text-align: center;
		}
		
		.product-card img {
		    width: 100%;
		    height: auto;
		    border-bottom: 1px solid #333333; /* Border between image and content */
		}
		
		.product-card h2 {
		    font-size: 18px;
		    color: #ffffff; /* White text color */
		    margin: 10px 0;
		}
		
		.product-card p {
		    font-size: 16px;
		    color: #b0b0b0; /* Light gray for price */
		    margin: 10px 0;
		}
		
		.quantity-selector {
		    display: flex;
		    align-items: center;
		    justify-content: center;
		    margin: 10px 0;
		}
		
		.quantity-btn {
		    background: #333333; /* Dark button background */
		    color: #ffffff; /* White text color */
		    border: none;
		    padding: 8px 12px;
		    font-size: 18px;
		    cursor: pointer;
		    transition: background 0.3s;
		}
		
		.quantity-btn:hover {
		    background: #444444; /* Slightly lighter on hover */
		}
		
		.quantity-input {
		    width: 40px;
		    text-align: center;
		    border: 1px solid #444444; /* Border to match dark theme */
		    padding: 8px;
		    font-size: 18px;
		    background-color: #333333; /* Dark input background */
		    color: #ffffff; /* White text color */
		}
		
		.add-to-cart {
		    background: #1e88e5; /* Material Blue color */
		    color: #ffffff; /* White text color */
		    border: none;
		    padding: 10px 20px;
		    border-radius: 4px;
		    cursor: pointer;
		    transition: background 0.3s;
		}
		
		.add-to-cart:hover {
		    background: #1565c0; /* Darker blue on hover */
		}
		
		.footer-links, .social-media {
		    display: flex;
		    justify-content: center;
		    padding: 20px;
		}
		
		.footer-links a {
		    margin: 0 15px;
		    text-decoration: none;
		    color: #e0e0e0; /* Light gray text color */
		    transition: color 0.3s;
		}
		
		.footer-links a:hover {
		    color: #ffffff; /* White text color on hover */
		}
		
		.social-media {
		    margin-top: 10px;
		}
    </style>
</head>
<body>
    <header>
        <div class="logo">MyStore</div>
        <input type="text" placeholder="Search..." class="search-bar">
        <div class="cart-icon">Cart</div>
    </header>
    <section class="hero">
        <img src="images/banner_img.jpg" alt="Featured Banner">
    </section>
    <section class="featured-products">
        <c:forEach var="product" items="${products}">
            <div class="product-card">
                <img src="image?id=${product.productId}" alt="${product.productName}" style="width: 100px; height: auto;" />
                <h2>${product.productName}</h2>
                <p>${product.productDescription}</p>
                <p>Rs.${product.productPrice}</p>
                <div class="quantity-selector">
                    <form action="cart" method="post">
					    <input type="hidden" name="productId" value="${product.productId}">
					    <div class="quantity-selector">
					        <button type="button" class="quantity-btn" onclick="decrementQuantity(this)">-</button>
					        <input type="text" name="quantity" value="1" class="quantity-input">
					        <button type="button" class="quantity-btn" onclick="incrementQuantity(this)">+</button>
					    </div>
					    <button type="submit" class="add-to-cart">Add to Cart</button>
					</form>
                </div>

            </div>
        </c:forEach>
    </section>
    <footer>
        <div class="footer-links">
            <a href="#">About Us</a>
            <a href="#">Contact</a>
            <a href="#">Privacy Policy</a>
            <a href="#">Terms of Service</a>
        </div>
        <div class="social-media">
            <!-- Social Media Icons -->
        </div>
    </footer>

    <script>
        function decrementQuantity(button) {
            const input = button.nextElementSibling;
            let value = parseInt(input.value, 10);
            if (value > 1) {
                input.value = value - 1;
            }
        }

        function incrementQuantity(button) {
            const input = button.previousElementSibling;
            let value = parseInt(input.value, 10);
            input.value = value + 1;
        }
    </script>
</body>
</html>