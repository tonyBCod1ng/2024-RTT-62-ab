<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Includes/Header.jsp"></jsp:include>


<div class="container">
    <div class="row text-center">
        <h2>Order - ${order.id}</h2>
        <div class="col col-2"></div>
    </div>
    <div class="row">
        <table class=" table col col-5" id="item-list">
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
            <div class="col col-2"></div>
        </div>
        <div class="row">
            <table class=" table col col-5" id="item-list">
                <tr>
                    <th>Item Id</th>
                    <th>Amount Ordered</th>
                    <th>Price Per Item</th>
                </tr>
                <c:forEach items="${order.orderDetails}" var="order">
                    <tr>
                        <td><a href="http://localhost:8080/item/${order.productID}">${order.productID}</a></td>
                        <td>${order.quantityOrdered}</td>
                        <td>${order.priceEach}</td>
                    </tr>
                </c:forEach>
            </table>
            <button onclick="window.location.assign('/../orders/')">Back</button>
            <div class="col col-2"></div>
        </div>
    </div>

<jsp:include page="Includes/Footer.jsp"></jsp:include>