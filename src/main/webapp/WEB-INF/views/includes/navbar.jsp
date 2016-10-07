<%-- 
    Document   : navbar.jsp
    Created on : Oct 6, 2016, 9:52:25 AM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" --%>
<div id="nav-bar" class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <c:url var="homeUrl" value="/" />
            <a class="brand" href="${homeUrl}">LDS</a>
            <div class="nav-collapse">
                <ul class="nav">
                    <!--sec:authorize access="authenticated" var="authenticated"/-->
                    <!--sec:authorize access="hasRole('ADMIN')" var="userRole"/-->
                    <c:choose>
                        <c:when test="${clientId != null}">
                            <c:url var="customerUrl" value="/customer/" />
                            <li><a id="navCustomerLink" href="${customerUrl}">Customer Details</a></li>
                            <c:url var="createLoanUrl" value= "/loan/create" />
                            <li><a id="navCreateLoanLink" href="${createLoanUrl}">Create Loan</a></li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
            <div id="nav-account" class="nav-collapse pull-right">
                <ul class="nav">
                    <c:choose>
                        <c:when test="${authenticated}">
                            <li id="greeting"><div>Welcome <!--sec:authentication property="name" /--></div></li>
                            <c:url var="logoutUrl" value="/customer/logout"/>
                            <li><a id="navLogoutLink" href="${logoutUrl}">Logout</a></li> 
                        </c:when>
                        <c:otherwise>
                            <c:url var="loginUrl" value="/customer/login"/>
                            <li><a id="navLoginLink" href="${loginUrl}">Login</a></li>
                            <c:url var="registerUrl" value="/customer/register" />
                            <li><a id="navRegisterUrl" href="${registerUrl}">Register</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</div>
