<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>


<div class="container">
    <div class="row text-center">
        <h2>${employee.firstname}, ${employee.lastname}</h2>
        <div class="col col-2"></div>
    </div>
    <div class="row">
        <table class=" table col col-5" >
            <tr>
                <th>Id</th>
                <td>${employee.id}</td>
            </tr>
            <tr>
                <th>Office</th>
                <td>${employee.office.city}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${employee.email}</td>
            </tr>
            <tr>
                <th>Extension</th>
                <td>${employee.extension}</td>
            </tr>
            <tr>
                <th>Manager</th>
                <td><c:if test="${employee.reportsTo > 0}"><a
                        href="../employee/${employee.reportsTo}">${manager.lastname}, ${manager.firstname}</a></c:if></td>
            </tr>
        </table>
        <div class="row text-center">
            <h2>${employee.firstname}'s Customers ( ${employee.customers.size()} )</h2>
            <div class="col col-2"></div>
        </div>
        <div class="row">
            <table class=" table col col-5" id="item-list">
                <tr>
                    <th>Name</th>
                </tr>
                <c:forEach items="${employee.customers}" var="customer">
                    <tr>
                        <td><a href="http://localhost:8080/customers/customer/${customer.id}">${customer.id}</a></td>
                        <td>${customer.customerName}</td>
                    </tr>
                </c:forEach>
            </table>
            <button onclick="window.location.assign('../../employees/')">Back</button>
            <div class="col col-2"></div>
        </div>
    </div>

<jsp:include page="../Includes/Footer.jsp"></jsp:include>