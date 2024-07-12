<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Includes/Header.jsp"></jsp:include>
<script>

    function handleChange(){
        let number = document.getElementById("id").value;
        window.location.assign("http://localhost:8080/item/" + number);
    }

</script>
<div class="row text-center">
    <div class="col col-12"><label for="id">Enter ID:</label>
        <input onchange="handleChange()" type="text" name="id" id="id"></div>
    <h2>Total products found: ${products.size()}</h2>
</div>

<div class="row">
    <div class="col col-2"></div>

    <table class="col col-8" id="item-list">
    <c:forEach items="${products}" var="product">


            <tr>
                <td>id</td>
                <td>${product.id}</td>
            </tr>
            <tr>
                <td>code</td>
                <td>${product.productCode}</td>
            </tr>
            <tr>
                <td>name</td>
                <td><a href="http://localhost:8080/item/${product.id}">${product.productName}</a></td>
            </tr>
            <tr>
                <td>description</td>
                <td>${product.productDescription}</td>
            </tr>

        
    </c:forEach>
    </table>

    <div class="col col-2"></div>
</div>
<jsp:include page="Includes/Footer.jsp"></jsp:include>