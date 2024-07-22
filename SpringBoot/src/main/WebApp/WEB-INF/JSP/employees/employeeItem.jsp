<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>


    <div class="row text-center">
<div class="col col-1"><a class="btn btn-primary" href="../../employees/">Back</a></div>
        <div class="col"><h2>${employee.firstname}, ${employee.lastname}</h2></div>
        <div class="col col-1"><a class="btn btn-warning" href="http://localhost:8080/employees/edit/${employee.id}">Edit</a>
        </div>
    </div>
    <div class="row justify-content-center cols-1">
        <div class="col col-4">
            <table class="table">
                <tr>
                    <th style="border-style: none">Id</th>
                    <td style="border-style: none">${employee.id}</td>
                </tr>
                <tr >
                    <th style="border-style: none">Office</th>
                    <td style="border-style: none">${employee.office.city}</td>
                </tr>
                <tr>
                    <th style="border-style: none">Email</th>
                    <td style="border-style: none">${employee.email}</td>
                </tr>
                <tr>
                    <th style="border-style: none">Extension</th>
                    <td style="border-style: none">${employee.extension}</td>
                </tr>
                <tr>
                    <th style="border-style: none">Manager</th>
                    <td style="border-style: none"><c:if test="${employee.reportsTo > 0}"><a
                            href="../employee/${employee.reportsTo}">${manager.lastname}, ${manager.firstname}</a></c:if>
                    </td>
                </tr>
            </table>
        </div>
        <div class="row justify-content-center text-center cols-1">
            <div class="col col-8"><h2>${employee.firstname}'s Customers ( ${employee.customers.size()} )</h2></div>
        </div>
        <div class="row justify-content-center">
            <div class="col col-10">
                <table class=" table col col-5" id="item-list">
                    <tr>
                        <th>Id</th>
                        <th>Company Name</th>
                        <th>Location</th>
                    </tr>
                    <c:forEach items="${employee.customers}" var="customer">
                        <tr>
                            <td><a href="http://localhost:8080/customers/customer/${customer.id}">${customer.id}</a>
                            </td>
                            <td>${customer.customerName}</td>
                            <td>${customer.country}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

<jsp:include page="../Includes/Footer.jsp"></jsp:include>