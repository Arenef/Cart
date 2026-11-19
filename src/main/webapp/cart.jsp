<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: baokh
  Date: 11/15/2026
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel = "stylesheet" href = "styles/main.css" type = "text/css">
</head>
<body>
<h1> Your cart</h1>
<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
        <th></th>
    </tr>
    <c:forEach var="lineProduct" items="${sessionScope.cart}">
        <tr>
            <td>
                <form action="updateQuantity" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="productCode" value="${lineProduct.product.productCode}">
                    <input type="text" name="quantity" value="${lineProduct.quantity}" required style="width: 25px">
                    <input type="submit" name="update" value="Update">
                </form>
            </td>
            <td>${lineProduct.product.description}</td>
            <td>${lineProduct.product.price}</td>
            <td>${lineProduct.product.price * lineProduct.quantity}</td>
            <td>
                <form action="removeProduct" method="post">
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="productCode" value="${lineProduct.product.productCode}">
                    <input type="submit" value="Remove">
                </form>
            </td>
        </tr>
    </c:forEach>


</table>
<p><b>To change the quantity </b>, enter the new quantity and click on the Update button</p>
<button>Continue Shopping</button><br>
<button>Checkout</button>
</body>
</html>