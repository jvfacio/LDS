<%--
    Document   : customer.jsp
    Created on : Oct 6, 2016, 11:28:10 AM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Customer Details" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

<form>
    <div class="form-group">
        <label for="firstName">First Name: ${client.getName()}</label>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name: ${client.getlastName()}</label>
    </div>
    <div class="form-group">
        <label for="address">Address: ${client.getAddress()}</label>
    </div>
    <div class="form-group">
        <label for="salary">Salary: ${client.getSalary()}</label>
    </div>
    <ul>
        <c:forEach var="loan" items="${client.getLoans()}">
            <li
        </c:forEach>
    </ul>
</form>


<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>