<%--
    Document   : customer.jsp
    Created on : Oct 6, 2016, 11:28:10 AM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Customer Details" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

        <div class="col-md-4">
            <table class="table table-hover">
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
                    <td>${client.getSalary()}</td>
                </tr>
            </table>
            
        </div>
        <div class="col-md-8">
            <h2>Loan History</h2>
            <table class="table table-hover">
                <tr>
                    <th>Type</th>
                    <th>Period</th>
                    <th>Interest</th>
                    <th>Amount Needed</th>
                </tr>
            
            
            
                    <c:forEach var="loan" items="${client.getLoans()}">
                        <tr>
                            <td>${loan.getLoanType()}</td>
                            
                            <td>${loan.getLoanPeriod()}</td>
                            <td>${loan.getInterest()}</td>
                            <td>${loan.getAmount()}</td>
                        </tr>
                    </c:forEach>
                </table>
        </div>






<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>