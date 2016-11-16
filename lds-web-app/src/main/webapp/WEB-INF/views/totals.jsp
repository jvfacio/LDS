<%--
    Document   : displayloan
    Created on : Oct 7, 2016, 2:33:26 PM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Loan Report" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <table class="table table-hover">
         <td> <h3><c:out value="${resultado}"></c:out> </h3> </td>
    </table>
    
    <table class="table table-hover">
    <tr>
        <td> Payment Every Month </td>
        <td> ---------------------- </td>
    </tr>
    <tr>
        <td> Total of 60 Payments </td>
        <td> ---------------------- </td>
    </tr>
    <tr>
        <td> Total Interest </td>
        <td> ---------------------- </td>
    </tr>
</table>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>

