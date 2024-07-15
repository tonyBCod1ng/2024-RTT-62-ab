<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>
<script>
    let showTable = false;

    function handleClick() {
        if (showTable === false) {
            document.getElementsByTagName("table")[0].remove();

        }
    }

</script>
<div class="container">
    <section>

        <div class="row">
            <div class="col col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col col-8">
                <form>
                    <div>
                        <label for="name" class="form-label"><h4>Employee Search</h4></label>
                        <input name="name" id="name" type="text" class="form-control" value="${name}"
                               placeholder="Enter name here">
                    </div>
                    <button type="submit" class="btn btn-primary m-3">Search</button>
                </form>
            </div>
        </div>
    </section>
    <section>
        <div class="row justify-content-center">

            <table class="table col col-5">
                <tr>
                    <th>Id</th>
                    <th>Office Number</th>
                    <th>Name</th>
                    <th>E-mail</th>
                </tr>
                <c:forEach items="${employees}" var="employee">

                    <tr>
                        <td>
                            <a href="http://localhost:8080/employees/employee/${employee.id}">${employee.id}</a>
                        </td>
                        <td>${employee.officeId}</td>
                        <td>${employee.firstname}, ${employee.lastname}</td>
                        <td>${employee.email}</td>
                    </tr>

                </c:forEach>
            </table>

        </div>
    </section>
</div>

<jsp:include page="../Includes/Footer.jsp"></jsp:include>