<%-- 
    Document   : restClient
    Created on : Oct 19, 2016, 10:00:15 AM
    Author     : Training
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Admin Tools - Client Lookup" scope="request"/>
<c:set var="jsImports" value="${['restClient']}" scope="request" />
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<!DOCTYPE html>
<div class="container">
    <form id="clientLookupForm" method="post">
        <input type="number" name="clientId" class="form-control" placeholder="Client ID"/>
        <input type="submit" class="btn-lg" value="Lookup Client" />
    </form>
    <div id="clientReport" class="container" style="display: none;">
        <ul class="list-group list-group-flush">
            <li class="list-group-item liitem"><strong>Nickname:</strong>
                <span id="client_nickName" class="pull-right"></span>
            </li>
            <li class="list-group-item liitem"><strong>First Name:</strong>
                <span id="client_name" class="pull-right"></span>
            </li>
            <li class="list-group-item liitem"><strong>Last Name:</strong>
                <span id="client_lastName" class="pull-right"></span>
            </li>
            <li class="list-group-item liitem"><strong>Address:</strong>
                <span id="client_address" class="pull-right"></span>
            </li>
            <li class="list-group-item liitem"><strong>Phone Number:</strong>
                <span id="client_phoneNumber" class="pull-right"></span>
            </li>
            <li class="list-group-item liitem"><strong>Salary:</strong>
                <span id="client_salary" class="pull-right"></span>
            </li>
        </ul>
        <div id="loanSummaryContainer" class="container">
            <h2> Loan Summary </h2>
            <ul id="loanSummaryList" class="container list-group" >
                <li class="row">

                </li>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>