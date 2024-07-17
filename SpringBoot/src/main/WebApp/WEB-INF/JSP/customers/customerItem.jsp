<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>


<div class="container">
    <div class="row text-center">
        <h2>${customer.customerName}</h2>
        <div class="col col-2"></div>
    </div>
    <div class="row">
        <table class=" table col col-5" id="item-list">
            <tr>
                <th>Id</th>
                <td>${customer.id}</td>
            </tr>
            <tr>
                <th>Contact</th>
                <td>${customer.contactFirstname}</td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>${customer.phone}</td>
            </tr>
            <tr>
                <th>Sales Rep</th>
                <td>
                    <a href="http://localhost:8080/employees/employee/${customer.salesRepEmployeeId}"> ${customer.employee.lastname}, ${customer.employee.firstname}</a>
                </td>
            </tr>

        </table>
        <div class="row text-center">
            <h2>${customer.customerName}'s Orders ( ${customer.orders.size()} )</h2>
            <div class="col col-2"></div>
        </div>
        <div class="row">
            <table class=" table col col-5" id="item-list">
                <tr>
                    <th>Order Id</th>
                    <th>Order Date</th>
                    <th>Required Date</th>
                    <th>Order Comment</th>
                </tr>
                <c:forEach items="${customer.orders}" var="order">
                    <tr>
                        <td><a href="http://localhost:8080/orders/order/${order.id}">${order.id}</a></td>
                        <td>${order.orderDate}</td>
                        <td>${order.requiredDate}</td>
                        <td>${order.comment}</td>
                    </tr>
                </c:forEach>
            </table>
            <button onclick="window.location.assign('/../customers/')">Back</button>
            <div class="col col-2"></div>
        </div>
    </div>

<jsp:include page="../Includes/Footer.jsp"></jsp:include>