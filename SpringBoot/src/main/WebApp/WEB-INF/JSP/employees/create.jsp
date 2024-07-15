<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>

<section>
    <div class="row">
        <div class="col col-12" style="height: 10vh"></div>
    </div>
    <div class="row justify-content-center text-center">
        <h4>Create Employee</h4>
    </div>
</section>
<section>
    <div class="row justify-content-center text-center">
        <div class="col col-10">
            <form action="http://localhost:8080/employees/createSubmit">
                <div class="row justify-content-center m-4">
                    <label for="officeId" class="form-label col col-1">Office Id</label>
                    <select id="officeId" name="officeId" style="width: 75%" class="col col-9 form-control">
                        <c:forEach items="${offices}" var="office">
                            <option value="${office.id}">${office.city}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="row justify-content-center m-4">
                    <label for="firstName" class="form-label col col-1">First Name</label>
                    <input id="firstName" name="firstName" class="col col-9" type="text"
                           aria-description="first name input">
                </div>
                <div class="row justify-content-center m-4">
                    <label for="lastname" class="form-label col col-1">Last Name</label>
                    <input id="lastname" name="lastName" class="col col-9" type="text"
                           aria-description="office id input">
                </div>
                <div class="row justify-content-center m-4">
                    <label for="extension" class="form-label col col-1">Ext.</label>
                    <input id="extension" name="extension" class="col col-9" type="text"
                           aria-description="extension input">
                </div>
                <div class="row justify-content-center m-4">
                    <label for="email" class="form-label col col-1">E-Mail</label>
                    <input id="email" name="email" class="col col-9" type="email" aria-description="email input">
                </div>
                <div class="row justify-content-center m-4">
                    <label for="jobTitle" class="form-label col col-1">Job Title</label>
                    <input id="jobTitle" name="jobTitle" class="col col-9" type="text"
                           aria-description="job title input">
                </div>

                <div class="row justify-content-center m-4">
                    <label for="reportsTo" class="form-label col col-1 text-center">Reports To</label>
                    <select id="reportsTo" style="width: 75%" name="reportsTo" class="col col-9 form-control">
                        <c:forEach items="${reportsTo}" var="employee">
                            <option value="${employee.id}">${employee.firstname} ${employee.lastname}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary m-1">Submit</button>
            </form>
        </div>
    </div>
</section>
<jsp:include page="../Includes/Footer.jsp"></jsp:include>