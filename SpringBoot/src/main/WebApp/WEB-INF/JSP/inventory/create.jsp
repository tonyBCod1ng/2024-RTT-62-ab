<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>

<section>

    <div class="row justify-content-center text-center">
        <c:choose>
            <c:when test="${form != null}">
                <h4>Edit Product</h4>
            </c:when>
            <c:otherwise>
                <h4>Create Product</h4>
            </c:otherwise>
        </c:choose>
    </div>
</section>
<section>
    <form action="http://localhost:8080/inventory/item/createSubmit">
        <input type="hidden" name="id" value="${form.id}">

        <div class="row justify-content-center m-4 cols-2">
            <div class="col col-2">
                <label for="productCode" class="form-label">Product Code</label>
            </div>
            <div class="col col-6">
                <input value="${form.productCode}" class="form-control" type="text" name="productCode" id="productCode">
                <div<c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productCode')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productCode')}">
                        ${bindingResult.getFieldError('productCode').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Product Code
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
        <div class="row justify-content-center m-4 cols-2">
            <div class="col col-2">
                <label for="productName" class="form-label">Product Name</label>
            </div>
            <div class="col col-6">
                <input value="${form.productName}" id="productName" name="productName"
                       class="form-control <c:if test="${bindingResult.hasFieldErrors('productName')}">is-invalid</c:if>"
                       type="text"
                       aria-description="product name input">
                <div <c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productName')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productName')}">
                        ${bindingResult.getFieldError('productName').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Product Name.
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>

        <div class="row justify-content-center m-4 cols-2">
            <div class="col col-2">
                <label for="productlineId" class="form-label">Product Line Id</label>
            </div>
            <div class="col col-6">
                <input value="${form.productlineId}" id="productlineId" name="productlineId"
                       class="form-control
                            <c:if test="${bindingResult.hasFieldErrors('productlineId')}">
                            is-invalid
                            </c:if>"
                       type="text"
                       aria-description="office id input">
                <div
                        <c:choose>
                            <c:when test="${bindingResult.hasFieldErrors('productlineId')}">
                                style="text-align: left;
                                padding-left: 15px;
                                "
                                class="invalid-feedback row form-text"
                            </c:when>
                            <c:otherwise>
                                style="padding-left: 15px"
                                class="row form-text"
                            </c:otherwise>
                        </c:choose>
                ><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productlineId')}">
                        ${bindingResult.getFieldError('productlineId').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Product Line Id
                    </c:otherwise>
                </c:choose></div>
            </div>
        </div>
        <div class="row justify-content-center m-4">
            <div class="col col-2">
                <label for="productScale" class="form-label">Product Scale</label>
            </div>
            <div class="col-6">
                <input value="${form.productScale}" id="productScale" name="productScale"
                       class="form-control <c:if test="${bindingResult.hasFieldErrors('productScale')}">is-invalid</c:if>"
                       type="text"
                       aria-description="product scale input">
                <div <c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productScale')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productScale')}">
                        ${bindingResult.getFieldError('productScale').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Product's Scale
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
        <div class="row justify-content-center m-4">
            <div class="col col-2">
                <label for="productVendor" class="form-label">Product Vendor</label>
            </div>
            <div class="col-6">
                <input value="${form.productVendor}" id="productVendor" name="productVendor"
                       class="form-control <c:if test="${bindingResult.hasFieldErrors('productVendor')}">is-invalid</c:if>"
                       type="text" aria-description="product vendor input">
                <div <c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productVendor')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productVendor')}">
                        ${bindingResult.getFieldError('productVendor').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Product's Vending Company.
                    </c:otherwise>
                </c:choose>
                </div>

            </div>
        </div>
        <div class="row justify-content-center m-4">
            <div class="col col-2">
                <label for="productDescription" class="form-label">Product Description</label>
            </div>
            <div class="col-6">
                <input value="${form.productDescription}" id="productDescription" name="productDescription"
                       class="form-control <c:if test="${bindingResult.hasFieldErrors('productDescription')}">is-invalid</c:if>"
                       type="text"
                       aria-description="product description input">
                <div<c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productDescription')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('productDescription')}">
                        ${bindingResult.getFieldError('productDescription').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Product Description.
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
        <div class="row justify-content-center m-4">
            <div class="col col-2">
                <label for="quantityInStock" class="form-label">Quantity In Stock</label>
            </div>
            <div class="col-6">
                <input value="${form.quantityInStock}" id="quantityInStock" name="quantityInStock"
                       class="form-control <c:if test="${bindingResult.hasFieldErrors('quantityInStock')}">is-invalid</c:if>"
                       type="text"
                       aria-description="quantity in stock input">
                <div<c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('quantityInStock')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('quantityInStock')}">
                        ${bindingResult.getFieldError('quantityInStock').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Quantity In Stock
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
        <div class="row justify-content-center m-4">
            <div class="col col-2">
                <label for="productDescription" class="form-label">Buy Price</label>
            </div>
            <div class="col-6">
                <input value="${form.buyPrice}" id="buyPrice" name="buyPrice"
                       class="form-control <c:if test="${bindingResult.hasFieldErrors('buyPrice')}">is-invalid</c:if>"
                       type="text"
                       aria-description="buy price input">
                <div<c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('buyPrice')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('buyPrice')}">
                        ${bindingResult.getFieldError('buyPrice').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        Buy Price
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>
        <div class="row justify-content-center m-4">
            <div class="col col-2">
                <label for="msrp" class="form-label">MSRP</label>
            </div>
            <div class="col-6">
                <input value="${form.msrp}" id="msrp" name="msrp"
                       class="form-control <c:if test="${bindingResult.hasFieldErrors('msrp')}">is-invalid</c:if>"
                       type="text"
                       aria-description="msrp input">
                <div<c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('msrp')}">
                        style="text-align: left;
                        padding-left: 15px;
                        "
                        class="invalid-feedback row form-text"
                    </c:when>
                    <c:otherwise>
                        style="padding-left: 15px"
                        class="row form-text"
                    </c:otherwise>
                </c:choose>><c:choose>
                    <c:when test="${bindingResult.hasFieldErrors('msrp')}">
                        ${bindingResult.getFieldError('msrp').defaultMessage}
                    </c:when>
                    <c:otherwise>
                        MSRP
                    </c:otherwise>
                </c:choose>
                </div>
            </div>
        </div>

        </div>

        <button type="submit" class="btn btn-primary m-1">Submit</button>
    </form>
</section>
<jsp:include page="../Includes/Footer.jsp"></jsp:include>