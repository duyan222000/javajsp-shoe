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
        <h2 class="my-4 text-center">Order History</h2>
        <c:choose>
            <c:when test="${not empty ordersList}">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Coupon ID</th>
                            <th>Order Date</th>
                            <th>Total Amount</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ordersList}" var="order">
                            <tr>
                                <td>${order.orderID}</td>
                                <td>${order.name}</td>
                                <td>${order.phone}</td>
                                <td>${order.couponID}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.totalAmount}</td>
                                <td><a href="orderDetails?orderID=${order.orderID}" class="btn btn-info">View Details</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-warning" role="alert">
                    No orders found!
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>
