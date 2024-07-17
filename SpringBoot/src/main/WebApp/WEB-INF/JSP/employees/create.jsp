<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>

<section>

    <div class="row justify-content-center text-center">
        <h4>Create Employee</h4>
    </div>
</section>
<section>
    <div class="row justify-content-center text-center">
        <div class="col col-10">
            <form action="http://localhost:8080/employees/createSubmit">
                <div class="row justify-content-center m-4 cols-2">
                    <div class="col col-2">
                        <label for="officeId" class="form-label">Office Id</label>
                    </div>
                    <div class="col col-6">
                        <select id="officeId" name="officeId" class="form-select">
                            <c:forEach items="${offices}" var="office">
                                <option
                                        <c:if test="${office.id == form.officeId}">selected</c:if>
                                        value="${office.id}">${office.city}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-center m-4 cols-2">
                    <div class="col col-2">
                        <label for="reportsTo" class="form-label">Reports To</label>
                    </div>
                    <div class="col col-6">
                        <select id="reportsTo" name="reportsTo" class="form-select">
                        <c:forEach items="${reportsTo}" var="employee">
                            <option
                                    <c:if test="${employee.id == form.reportsTo}">selected</c:if>
                                    value="${employee.id}">${employee.firstname} ${employee.lastname}
                            </option>
                        </c:forEach>
                    </select>
                    </div>
                    <div class="row justify-content-center m-4 cols-2">
                        <div class="col col-2"><label for="firstName" class="form-label">First Name</label></div>
                        <div class="col col-6"><input value="${form.firstName}" id="firstName" name="firstName"
                                                class="form-control <c:if test="${bindingResult.hasFieldErrors('firstName')}">is-invalid</c:if>"
                                                type="text"
                                                aria-description="first name input">
                            <div <c:choose>
                                <c:when test="${bindingResult.hasFieldErrors('lastName')}">
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
                                <c:when test="${bindingResult.hasFieldErrors('firstName')}">
                                    ${bindingResult.getFieldError('firstName').defaultMessage}
                                </c:when>
                                <c:otherwise>
                                    Employee's First Name.
                                </c:otherwise>
                            </c:choose>
                            </div>
                        </div>
                    </div>

                    <div class="row justify-content-center m-4 cols-2">
                        <div class="col col-2"><label for="lastname" class="form-label">Last Name</label></div>
                        <div class="col col-6"><input value="${form.lastName}" id="lastname" name="lastName"
                                                class="form-control <c:if test="${bindingResult.hasFieldErrors('lastName')}">is-invalid</c:if>"
                                                type="text"
                                                aria-description="office id input">
                            <div
                                    <c:choose>
                                        <c:when test="${bindingResult.hasFieldErrors('lastName')}">
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
                                <c:when test="${bindingResult.hasFieldErrors('lastName')}">
                                    ${bindingResult.getFieldError('lastName').defaultMessage}
                                </c:when>
                                <c:otherwise>
                                    Employee's Last Name.
                                </c:otherwise>
                            </c:choose></div>
                        </div>
                    </div>
                    <div class="row justify-content-center m-4">
                        <div class="col col-2"><label for="extension" class="form-label">Ext.</label></div>
                        <div class="col-6"><input value="${form.extension}" id="extension" name="extension"
                                                class="form-control <c:if test="${bindingResult.hasFieldErrors('extension')}">is-invalid</c:if>"
                                                type="text"
                                                aria-description="extension input">
                            <div <c:choose>
                                <c:when test="${bindingResult.hasFieldErrors('extension')}">
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
                                <c:when test="${bindingResult.hasFieldErrors('extension')}">
                                    ${bindingResult.getFieldError('extension').defaultMessage}
                                </c:when>
                                <c:otherwise>
                                    Employee's Phone Extension.
                                </c:otherwise>
                            </c:choose>
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-center m-4">
                        <div class="col col-2"><label for="email" class="form-label">E-Mail</label></div>
                        <div class="col-6"><input value="${form.email}" id="email" name="email"
                                                class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>"
                                                type="text" aria-description="email input">
                            <div <c:choose>
                                <c:when test="${bindingResult.hasFieldErrors('email')}">
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
                                <c:when test="${bindingResult.hasFieldErrors('email')}">
                                    ${bindingResult.getFieldError('email').defaultMessage}
                                </c:when>
                                <c:otherwise>
                                    Employee's Company E-mail.
                                </c:otherwise>
                            </c:choose>
                            </div>

                        </div>
                    </div>
                    <div class="row justify-content-center m-4">
                        <div class="col col-2"><label for="jobTitle" class="form-label">Job Title</label>
                        </div>
                        <div class="col-6">
                            <input value="${form.jobTitle}" id="jobTitle" name="jobTitle"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('jobTitle')}">is-invalid</c:if>"
                                   type="text"
                                   aria-description="job title input">
                            <div<c:choose>
                                <c:when test="${bindingResult.hasFieldErrors('jobTitle')}">
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
                                <c:when test="${bindingResult.hasFieldErrors('jobTitle')}">
                                    ${bindingResult.getFieldError('jobTitle').defaultMessage}
                                </c:when>
                                <c:otherwise>
                                    Employee's Job Title.
                                </c:otherwise>
                            </c:choose>
                            </div>
                        </div>
                    </div>

                </div>

                <button type="submit" class="btn btn-primary m-1">Submit</button>
            </form>
        </div>
    </div>
</section>
<jsp:include page="../Includes/Footer.jsp"></jsp:include>