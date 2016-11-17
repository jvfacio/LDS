<%--
    Document   : displayloan
    Created on : Oct 7, 2016, 2:33:26 PM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Loan Report" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<h2>Overview</h2>
<table class="table table-hover">
    <tr>
        <td> Type </td>
        <td>${loan.getLoanType()}</td>
    </tr>
    <tr>
        <td> Period </td>
        <td> ${loan.getLoanPeriod()} Years </td>
    </tr>
    <tr>
        <td> Interest </td>
        <td> ${percentages.format(loan.getInterest())}% </td>
    </tr>
    <tr>
        <td> Principal </td>
        <td> &#36;${decimals.format(loan.getAmount())} </td>
    </tr>
    </table>
    <h2> Payment Summary </h2>
        <table class="table table-hover">
            <tr>
                <td> Monthly Payment </td>
                <td> $ <c:out value="${paymonthly}"></c:out> </td>
                </tr>
                <tr>
                    <td> Total of <c:out value="${numberpayments}"></c:out> Payments </td>
                <td> $ <c:out value="${total}"></c:out> </td>
                </tr>
                <tr>
                    <td> Total Interest Paid </td>
                    <td> $ <c:out value="${totalinterest}"></c:out> </td>
                </tr>
        </table>

    <h2>Monthly Payments</h2>

    <table class="table table-hover">
        <tr>
            <th>#</th>
            <th>Date</th>
            <th>Beginning Balance</th>
            <th>Interest Paid</th>
            <th>Principal Paid</th>
            <th>Ending Balance</th>
            
        </tr>

    <c:forEach var="payment" items="${loan.getPaymentDetail()}">
        <tr>
            <td> ${payment.getNumOfPayment()} </td>
            <td> ${payment.getFormattedDate()} </td>
            <td> $ ${decimals.format(payment.getBeginningBalance())} </td>
            <td> $ ${decimals.format(payment.getInterest())} </td>
            <td> $ ${decimals.format(payment.getPrincipal())} </td>
            <td> $ ${decimals.format(payment.getEndingBalance())} </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>

