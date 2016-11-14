<%--
    Document   : customer.jsp
    Created on : Oct 6, 2016, 11:28:10 AM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Customer Details" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<c:set var="client" value="${clientSession.getClient()}" scope="page"/>
<div class="container">
<div class="row">
    <div class="col-md-4">
            <table class="table table-condensed">
                <tr>
                    <td>Nickname</td>
                    <td>${client.getNickName()}</td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td>${client.getName()}</td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>${client.getlastName()}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${client.getAddress()}</td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td>&#36;${client.getSalary()}</td>
                </tr>
            </table>
        </div>
        <div class="col-md-8">
            <h2>Loan History</h2>
            <table class="table table-condensed">
                <tr>
                    <th>Type</th>
                    <th>Period</th>
                    <th>Interest</th>
                    <th>Amount Needed</th>
                    <th>Details</th>
                    <th></th>
                </tr>
                    <c:forEach var="loan" items="${client.getLoans()}">
                        <tr>
                            <td>${loan.getLoanType()}</td>        
                            <td>${loan.getLoanPeriod()} Years</td>
                            <td>${loan.getInterest()}%</td>
                            <td>&#36;${loan.getAmount()}</td>
                            <td><a class="btn btn-default" href="/LDS/loan/display?id=${loan.getLoanID()}&disp=HTML" role="button">View</a></td>
                            <td><a class="btn btn-default" href="/LDS/loan/display?id=${loan.getLoanID()}&disp=PDF" role="button" download>Download PDF</a></td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
</div>
         
</div>   
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>