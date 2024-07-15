<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Includes/Header.jsp"></jsp:include>

<div class="container">
    <section>

        <div class="row">
            <div class="col col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col col-8">
                <form>
                    <div>
                        <label for="name" class="form-label"><h4>Order Search</h4></label>
                        <input name="name" id="name" type="text" class="form-control" value="${name}" placeholder="Enter name here">
                    </div>
                    <button type="submit" class="btn btn-primary m-3">Search</button>
                </form>
            </div>
        </div>
    </section>
    <section>
        <div class="row justify-content-center">

            <table class="table col col-5" >
                <tr>
                    <th>Order Id</th>
                    <th>Customer Id</th>
                    <th>Order Date</th>
                    <th>Shipped Date</th>
                </tr>
                <c:forEach items="${orders}" var="order">

                    <tr>
                        <td><a href="http://localhost:8080/orders/order/${order.id}">${order.id}</a></td>
                        <td>${order.customerId}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.shippedDate}</td>
                    </tr>

                </c:forEach>
            </table>

        </div>
    </section>
</div>

<jsp:include page="Includes/Footer.jsp"></jsp:include>