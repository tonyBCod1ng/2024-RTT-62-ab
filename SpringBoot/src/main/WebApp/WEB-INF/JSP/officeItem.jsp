<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Includes/Header.jsp"></jsp:include>

<button class="btn btn-primary col-1 m-1" onclick="window.location.assign('../../offices/')">Back</button>
    <div class="row text-center cols-2">
        <div class="col col-12"><h2>${office.id} - ${office.city}</h2></div>
        <div class="col col-12" style="height: 5vh"><h2></h2></div>
    </div>
    <div class="row justify-content-center text-center">
        <div class="col col-8">
            <table class="table">
                <tr>
                    <th style="border-style: none">City</th>
                    <td style="border-style: none">${office.city}</td>
                </tr>
                <tr>
                    <th style="border-style: none">Country</th>
                    <td style="border-style: none">${office.country}</td>
                </tr>
                <tr>
                    <th style="border-style: none">Address</th>
                    <td style="border-style: none">${office.addressLine1}</td>
                </tr>
            </table>
        </div>
        <div class="row text-center">
            <h2>Employees ( ${office.employees.size()} )</h2>
        </div>
        <div class="row">
            <table class=" table table-hover">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Job Title</th>
                </tr>
                <c:forEach items="${office.employees}" var="employee">
                    <tr>
                        <td><a href="http://localhost:8080/customers/customer/${employee.id}">${employee.id}</a></td>
                        <td>${employee.lastname}, ${employee.firstname}</td>
                        <td>${employee.jobTitle}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="col col-2"></div>
        </div>

<jsp:include page="Includes/Footer.jsp"></jsp:include>