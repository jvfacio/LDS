<%--
    Document   : displayloan
    Created on : Oct 7, 2016, 2:33:26 PM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Loan Report" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<h3>Loan Report</h3>
<table class="table table-hover">
    <tr>
        <th>Amount</th>
        <th>Date</th>
    </tr>
    <c:forEach var="payment" items="${report.getMonthPaymentLst()}">
        <tr>
            <td> ${payment.getAmount()} </td>
            <td> ${payment.getFormattedDate()}</td>
        </tr>
    </c:forEach>
</table>



<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>



