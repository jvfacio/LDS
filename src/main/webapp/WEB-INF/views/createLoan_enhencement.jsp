<%--
    Document   : createLoan.jsp
    Created on : Oct 4, 2016, 3:37:52 PM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Create a Loan" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <form action="create" method="post">
                <div class="form-group">
                    <label for="loanTypeInput">Type</label>
                    <!--input type="text" class="form-control" id="loanTypeInput" name="type" placeholder="Type"-->
                    <select class="form-control" id="loanTypeInput" name="type" placeholder="Type">
                        <option>Select...</option>
                        <option value="Mortgage">Mortgage</option>
                        <option value="Credit">Credit</option>
                        <option Value="car">Car</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="loanPeriodInput">Loan Period</label>
                    <!--input type="text" class="form-control" id="loanPeriodInput" name="loanperiod" placeholder="Years"-->
                    <input type="radio" name="loanperiod" value="10"/> 10 Years <br>
                    <input type="radio" name="loanperiod" value="15"/> 15 Years <br>
                    <input type="radio" name="loanperiod" value="20"/>20 Years
                </div>
                <div class="form-group">
                    <label for="loanInterestInput">Interest</label>
                    <input type="number" step=0.01 class="form-control" id="loanInterestInput" name="interest" placeholder="Interest  (%)">
                </div>
                <div class="form-group">
                    <label for="loanAmountInput">Amount</label>
                    <input type="number" step=0.01 class="form-control" id="loanAmountInput" name="amount" placeholder="Amount  (MXN)"> 
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>

        </div>
        <div class="col-xs-12 col-md-8"></div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>



