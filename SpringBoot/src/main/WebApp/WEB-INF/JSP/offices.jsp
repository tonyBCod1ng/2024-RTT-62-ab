<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Includes/Header.jsp"></jsp:include>

<div class="container">
    <section>

        <div class="row">
            <div class="col col-12" style="height: 10vh"></div>
        </div>
        <div class="row justify-content-center text-center">
            <div class="col col-8">
              <h2>Offices</h2>
            </div>
        </div>
    </section>
    <section>
        <div class="row justify-content-center">

            <table class="table col col-5">
                <tr>
                    <th>Office Number</th>
                    <th>Country</th>
                    <th>City</th>
                    <th>Territory</th>
                </tr>
                <c:forEach items="${offices}" var="office">

                    <tr>
                        <td>
                           ${office.id}
                        </td>
                        <td>${office.country}</td>
                        <td>${office.city}</td>
                        <td>${office.territory}</td>
                    </tr>

                </c:forEach>
            </table>

        </div>
    </section>
</div>

<jsp:include page="Includes/Footer.jsp"></jsp:include>