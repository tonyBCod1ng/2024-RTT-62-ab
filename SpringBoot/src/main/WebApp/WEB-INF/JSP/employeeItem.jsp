<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Includes/Header.jsp"></jsp:include>


<div class="container">
    <div class="row text-center">
        <h2>${employee.firstname}, ${employee.lastname}</h2>
        <div class="col col-2"></div>
    </div>
    <div class="row">
        <table class=" table col col-5" id="item-list">
                <tr>
                    <th>Id</th>
                    <td>${employee.id}</td>
                </tr>
                <tr>
                    <th>Office</th>
                    <td>${employee.officeId}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>${employee.email}</td>
                </tr>
                <tr>
                    <th>Extension</th>
                    <td>${employee.extension}</td>
                </tr>
        </table>
        <button onclick="window.location.assign('/../employees/employee')">Back</button>
        <div class="col col-2"></div>
    </div>
</div>

<jsp:include page="Includes/Footer.jsp"></jsp:include>