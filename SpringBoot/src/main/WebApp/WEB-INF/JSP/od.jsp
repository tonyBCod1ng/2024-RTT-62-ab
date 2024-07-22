<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="Includes/Header.jsp" />

<h1>This is the order detail</h1>


<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Order Details (${orderDetails.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>Order Id</th>
                        <th>Order Date</th>
                        <th>Product Name</th>
                        <th>Quantity Ordered</th>
                        <th>Price Each</th>
                        <th>Line Item Total</th>
                    </tr>
                    <c:forEach items="${orderDetails}" var="detail">
                        <tr>
                            <td>${detail.order_id}</td>
                            <td>${detail.order_date}</td>
                            <td>${detail.product_name}</td>
                            <td>${detail.quantity_ordered}</td>
                            <td><fmt:formatNumber type="currency">${detail.price_each}</fmt:formatNumber> </td>
                            <td><fmt:formatNumber type="currency">${detail.total}</fmt:formatNumber> </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>




<jsp:include page="Includes/Footer.jsp" />