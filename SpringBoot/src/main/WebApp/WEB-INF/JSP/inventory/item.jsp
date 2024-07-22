<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Includes/Header.jsp"></jsp:include>


    <div class="row text-center">
        <div class="col col-1"><a class="btn btn-primary" href="/../inventory">Back</a></div>

<div class="col"><h2>${product.productName}</h2></div>
        <div class="col col-1"><a class="btn btn-warning" href="/../inventory/item/edit/${product.id}">Edit</a></div>
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
    </div>

<jsp:include page="../Includes/Footer.jsp"></jsp:include>