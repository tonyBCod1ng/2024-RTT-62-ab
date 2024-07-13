<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Includes/Header.jsp"></jsp:include>

<div class="container">
    <div class="row text-center">
        <h2>${product.productName}</h2>
        <div class="col col-2"></div>
    </div>
    <div class="row">
        <table class="table col col-8">

            <tr>
                <th>id</th>
                <td>${product.id}</td>
            </tr>
            <tr>
                <th>code</th>
                <td>${product.productCode}</td>
            </tr>
            <tr>
                <th>name</th>
                <td>${product.productName}</td>
            </tr>
            <tr>
                <th>description</th>
                <td>${product.productDescription}</td>
            </tr>
            <tr>
                <th>MSRP</th>
                <td>${product.msrp}</td>
            </tr>

        </table>
        <button onclick="window.location.assign('/../inventory')">Back</button>
        <div class="col col-2"></div>
    </div>
</div>
<jsp:include page="Includes/Footer.jsp"></jsp:include>