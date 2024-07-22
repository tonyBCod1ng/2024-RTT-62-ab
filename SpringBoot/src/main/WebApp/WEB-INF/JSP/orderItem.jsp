<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:include page="Includes/Header.jsp"></jsp:include>
<script>
    let totalSpent = 0;
    function add(num){
        totalSpent += num;
    }
</script>

<div class="container">
    <div class="row text-center">
        <div class="col col-1"><a class="btn btn-primary" href="/../orders/">Back</a></div>
        <div class="col"><h2>Order - ${order.id}</h2></div>
        <div class="col col-1"><a class="btn btn-danger" href="/../orders/edit/${order.id}">edit</a></div>
    </div>
    <div class="row justify-content-center">
        <table class="table">
            <tr>
                <th>Order Date</th>
                <td>${order.orderDate}</td>
            </tr>
            <tr>
                <th>Shipped</th>
                <td>${order.shippedDate}</td>
            </tr>

        </table>
        <div class="row text-center">
            <h2>Order Details</h2>
        </div>
        <div class="row">
            <table class=" table col col-5" id="item-list">
                <tr>
                    <th>Item</th>
                    <th>Amount Ordered</th>
                    <th>Price Per Item</th>
                    <th>Subtotal</th>
                </tr>
                <c:forEach items="${order.orderDetails}" var="order">
                    <tr>
                        <td><a href="http://localhost:8080/item/${order.productID}">${order.product.productName}</a></td>
                        <td>${order.quantityOrdered}</td>
                        <td><fmt:formatNumber type="currency">${order.priceEach}</fmt:formatNumber></td>

                            <td onload="add(String(${order.priceEach * order.quantityOrdered}))">
                                <fmt:formatNumber type="currency" value="${order.priceEach * order.quantityOrdered}"></fmt:formatNumber></td>


                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
<jsp:include page="Includes/Footer.jsp"></jsp:include>