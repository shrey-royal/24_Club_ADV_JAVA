<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <style type="text/css">
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #121212;
            color: #e0e0e0;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .cart-container {
            padding: 20px;
        }
        .cart-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #444444;
        }
        .cart-item img {
            width: 100px;
            height: auto;
        }
        .cart-item-info {
            flex: 1;
            margin-left: 20px;
        }
        .cart-item-name {
            font-size: 18px;
            color: #ffffff;
        }
        .cart-item-quantity {
            font-size: 16px;
            color: #b0b0b0;
        }
        .cart-item-price {
            font-size: 18px;
            color: #ffffff;
        }
        .cart-total {
            text-align: right;
            font-size: 20px;
            padding: 10px;
            color: #ffffff;
        }
        .checkout-btn {
            background: #1e88e5;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            display: block;
            width: 100%;
            text-align: center;
            margin-top: 20px;
        }
        .checkout-btn:hover {
            background: #1565c0;
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <h1>Your Shopping Cart</h1>
        <c:forEach var="item" items="${cart}">
            <div class="cart-item">
                <div class="cart-item-info">
                    <div class="cart-item-name">${item.productName}</div>
                    <div class="cart-item-quantity">Quantity: ${item.quantity}</div>
                </div>
                <div class="cart-item-price">Rs.${item.price * item.quantity}</div>
            </div>
        </c:forEach>
        <div class="cart-total">
            Total: Rs.
            <c:forEach var="item" items="${cart}" varStatus="status">
                <c:if test="${status.first}">
                    ${item.price * item.quantity}
                </c:if>
                <c:if test="${!status.first}">
                    + ${item.price * item.quantity}
                </c:if>
            </c:forEach>
        </div>
        <button class="checkout-btn">Proceed to Checkout</button>
    </div>
</body>
</html>
