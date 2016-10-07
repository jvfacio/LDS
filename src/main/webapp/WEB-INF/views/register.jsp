<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Register" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <form action="register" method="post">
                <div class="form-group">
                    <label for="custFirstName">First Name</label>
                    <input type="text" class="form-control" id="custFirstName" name="name" placeholder="First Name">
                </div>
                <div class="form-group">
                    <label for="custLastName">Last Name</label>
                    <input type="text" class="form-control" id="custLastName" name="lastName" placeholder="Last Name">
                </div>
                <div class="form-group">
                    <label for="custAddress">Address</label>
                    <input type="text" class="form-control" id="custAddress" name="address" placeholder="Address">
                </div>
                <div class="form-group">
                    <label for="custPhone">Phone Number</label>
                    <input type="tel" class="form-control" id="custPhone" name="phone" placeholder="Phone Number">
                </div>
                <div class="form-group">
                    <label for="custSalary">Salary</label>
                    <input type="number" class="form-control" id="custSalary" name="salary" placeholder="Salary">
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>

        </div>
        <div class="col-xs-12 col-md-8"></div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>




