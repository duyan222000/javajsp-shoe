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
    <h2>Shopping Cart</h2>
    <c:if test="${empty cart.items}">
        <p>Your cart is empty.</p>
    </c:if>
    <c:if test="${not empty cart.items}">
        <table class="table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart.items}">
                    <tr id="item-row-${item.product.id}">
                        <td>${item.product.name}</td>
                        <td>
                        	<img src="${item.product.image}">
                        </td>	
                        <td>${item.product.price}</td>
                        <%-- <td>${item.quantity}</td> --%>
                        <td>
                            <button class="btn btn-secondary" onclick="updateQuantity(${item.product.id}, 'decrease')">-</button>
                            <span id="quantity-${item.product.id}">${item.quantity}</span>
                            <button class="btn btn-secondary" onclick="updateQuantity(${item.product.id}, 'increase')">+</button>
                        </td>
                        <%-- <td>${item.totalPrice}</td> --%>
                        <td id="total-${item.product.id}">${item.totalPrice}</td>
                        <td>
                        	<button class="btn btn-danger" 
                        			onClick="removeItem(${item.product.id})"
                        	>
                        	Remove
                        	</button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">Total</td>
                    <td colspan="2" id="cart-total">${cart.totalPrice}</td>
                </tr>
            </tbody>
        </table>
        <form action="checkout" method="post">
            <button type="submit" class="btn btn-primary">Checkout</button>
        </form>
    </c:if>
</div>

<script>
function updateQuantity(productId, action) {
    $.ajax({
        url: 'cart',
        method: 'POST',
        data: { productId: productId, action: action },
        success: function(response) {
        	console.log("Response: ", response); // Log Response Information
            $('#quantity-' + productId).text(response.quantity);
            $('#total-' + productId).text(response.totalPrice);
            $('#cart-total').text(response.cartTotal);
        },
        error: function(xhr, status, error){
            console.error("Error status: ", status); // Log Error Status
            console.error("Error details: ", error); // Log Error Detail
            console.error("Response: ", xhr.responseText); // Log response from server
            alert('error!');
        }
    });
}

function removeItem(productId) {
    $.ajax({
        url: 'cart', // Ensure this matches the servlet URL mapping
        method: 'POST',
        data: { productId: productId, action: 'remove' },
        dataType: 'text',
        success: function(response) {
            console.log("Response: ", response); // Log Response Information
            $('#item-row-' + productId).remove(); // Remove the item row from the table
            
            var data = JSON.parse(response);
            
            $('#cart-total').text(data.cartTotal); // Update cart total
        },
        error: function(xhr, status, error){
            console.error("Error status: ", status); // Log Error Status
            console.error("Error details: ", error); // Log Error Detail
            console.error("Response: ", xhr.responseText); // Log response from server
            alert('error!');
        }
    });
}

</script>
</body>
</html>
