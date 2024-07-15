<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../Includes/Header.jsp"></jsp:include>

<div class="container">
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
                        <label for="name" class="form-label col col-1">Name</label>
                        <input id="name" name="name" class="col col-9" type="text" aria-description="name input">
                    </div>
                    <div class="row justify-content-center m-4">
                        <label for="name" class="form-label col col-1">E-mail</label>
                        <input id="email" name="email" class="col col-9" type="email" aria-description="email input">
                    </div>
                    <div class="row justify-content-center m-4">
                        <label for="name" class="form-label col col-1">Phone</label>
                        <input id="phone" name="phone" class="col col-9" type="tel" aria-description="phone input">
                    </div>

                    <button type="submit" class="btn btn-primary m-1">Submit</button>
                </form>
            </div>
        </div>
    </section>
</div>
<jsp:include page="../Includes/Footer.jsp"></jsp:include>