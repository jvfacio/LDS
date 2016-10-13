<%--
    Document   : displayloan
    Created on : Oct 7, 2016, 2:33:26 PM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Loan Report" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<table class="table table-hover">
    <tr>
        <td> Type </td>
        <td>${report.getLoan().getLoanType()}</td>
    </tr>
    <tr>
        <td> Period </td>
        <td> ${report.getLoan().getLoanPeriod()} Years </td>
    </tr>
    <tr>
        <td> Interest </td>
        <td> ${report.getLoan().getInterest()}% </td>
    </tr>
    <tr>
        <td> Amount </td>
        <td> &#36;${report.getLoan().getAmount()} </td>
    </tr>
    <tr>
        <td> Total Monthly Payments </td>
        <td> ${report.getMonthPaymentLst().size()}
    </tr>
</table>
<h3>Monthly Payments</h3>
<table class="table table-hover">
    <tr>
        <td>Payment</td>
        <th>Amount</th>
        <th>Date</th>
    </tr>
    <c:set var="count" value="0" scope="page" />
    <c:forEach var="payment" items="${report.getMonthPaymentLst()}">
        <tr>
            <td>${count}</td>
            <c:set var="count" value="${count + 1}" scope="page"/>
            <td> &#36;${payment.getAmount()} </td>
            <td> ${payment.getFormattedDate()}</td>
        </tr>
    </c:forEach>
</table>



<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>

