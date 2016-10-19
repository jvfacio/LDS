<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="pageTitle" value="Register" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <form:form action="register" method="post" modelAttribute="client">
                <div class="form-group">
                    <form:label path="nickName">Nickname</form:label>
                    <form:input type="text" class="form-conrol" path="nickName" placeholder="Nickname"/>
                </div>
                <div class="form-group">
                    <form:label path = "pass">Password</form:label>
                    <form:input type="password" class="form-control" path="pass" placeholder="Password"/>
                </div>
                <div class="form-group">
                    <form:label path = "name">First Name</form:label>
                    <form:input type="text" class="form-control" path="name" placeholder="First Name"/>
                </div>
                <div class="form-group">
                    <form:label path = "lastName">Last Name</form:label>
                    <form:input type="text" class="form-control" path="lastName" placeholder="Last Name"/>
                </div>
                <div class="form-group">
                    <form:label path = "address">Address</form:label>
                    <form:input type="text" class="form-control" path="address" placeholder="Address"/>
                </div>
                <div class="form-group">
                    <form:label path = "phoneNumber">Phone Number</form:label>
                    <form:input type="tel" class="form-control" path="phoneNumber" placeholder="Phone Number"/>
                </div>
                <div class="form-group">
                    <form:label path = "salary">Salary</form:label>
                    <form:input type="number" class="form-control" path="salary" placeholder="Salary"/>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form:form>
        </div>
        <div class="col-xs-12 col-md-8"></div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>




