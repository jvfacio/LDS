<%--
    Document   : customer.jsp
    Created on : Oct 6, 2016, 11:28:10 AM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Customer Details" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6">
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
                
            </form>
        </div>
        <div class="col-xs-6">
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
    </div>
</div>






<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>