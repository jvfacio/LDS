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
        <td>${loan.getLoanType()}</td>
    </tr>
    <tr>
        <td> Period </td>
        <td> ${loan.getLoanPeriod()} Years </td>
    </tr>
    <tr>
        <td> Interest </td>
        <td> ${loan.getInterest()}% </td>
    </tr>
    <tr>
        <td> Amount </td>
        <td> &#36;${loan.getAmount()} </td>
    </tr>
    <tr>
        <td> Totals </td>
        <td> 

            <table class="table table-hover">
                <tr>
                    <td> Payment Every Month </td>
                    <td> <c:out value="${paymonthly}"></c:out> </td>
                    </tr>
                    <tr>
                        <td> Total of <c:out value="${numberpayments}"></c:out> Payments </td>
                    <td> <c:out value="${total}"></c:out> </td>
                    </tr>
                    <tr>
                        <td> Total Interest </td>
                        <td>  <c:out value="${totalinteres}"></c:out> </td>
                    </tr>
                </table>

            </td>
        </tr>
    </table>
    <table class="table table-hover">
        <td> <h3>Monthly Payments</h3> </td>
    </table>

    <table class="table table-hover">
        <tr>
            <td>Payment</td>
            <th>Beginning Balance</th>
            <th>Interes</th>
            <th>Principal</th>
            <th>Endinig Balance</th>
            <th>Date</th>
            <th>Payment Amount</th>
        </tr>
    <c:set var="count" value="1" scope="page" />
    <c:forEach var="payment" items="${loan.getPaymentDetail()}">
        <tr>
            <td> ${payment.getNumOfPayment()} </td>
            <td> ${payment.getBeginningBalance()} </td>
            <th> ${payment.getInterest()} </th>
            <th> ${payment.getPrincipal()} </th>
            <th> ${payment.getEndingBalance()} </th>
            <th> ${payment.getDate()} </th>
            <td> ${payment.getPrincipal() + payment.getInterest()}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>

