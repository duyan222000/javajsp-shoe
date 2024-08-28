<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
     	img{
          width: 200px;
          height: 120px;
    	}
    </style>
</head>
<body>
    <div class="container">
        <h2 class="my-4 text-center">Order Details</h2>
        <div>
            <h4>Order Information</h4>
            <p><strong>Order ID:</strong> ${order.orderID}</p>
            <p><strong>Name:</strong> ${order.name}</p>
            <p><strong>Phone:</strong> ${order.phone}</p>
            <p><strong>Coupon ID:</strong> ${order.couponID}</p>
            <p><strong>Order Date:</strong> ${order.orderDate}</p>
            <p><strong>Total Amount:</strong> ${order.totalAmount}</p>
        </div>
        <div>
            <h4>Order Items</h4>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orderDetails}" var="detail">
                        <tr>
                            <td>${detail.productID}</td>
                            <td>${detail.quantity}</td>
                            <td>${detail.price}</td>
                            <td>${detail.quantity * detail.price}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <a href="adminOrders" class="btn btn-secondary">Back to Orders List</a>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
