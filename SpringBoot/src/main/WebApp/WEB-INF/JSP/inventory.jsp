<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Includes/Header.jsp"></jsp:include>
<script>

    function handleChange() {
        let number = document.getElementById("id").value;
        window.location.assign("http://localhost:8080/item/" + number);
    }

</script>
<!-- a search form -->
<div class="container">
    <section>

        <div class="row">
            <div class="col col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col col-8">
                <form>
                    <div>
                        <label for="name" class="form-label"><h4>Inventory Search</h4></label>
                        <input name="search" id="name" type="text" class="form-control" value="${name}" placeholder="Enter name here">
                    </div>
                    <button type="submit" class="btn btn-primary m-3">Search</button>
                </form>
            </div>
        </div>
    </section>

    <div class="row justify-content-center">

        <table class="table col col-5" >
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Item Description</th>
            </tr>
            <c:forEach items="${products}" var="product">

                <tr>
                    <td>${product.id}</td>
                    <td><a href="http://localhost:8080/item/${product.id}">${product.productName}</a></td>
                    <td>${product.productDescription}</td>
                </tr>

            </c:forEach>
        </table>

        <div class="col col-2"></div>
    </div>
</div>
<jsp:include page="Includes/Footer.jsp"></jsp:include>
