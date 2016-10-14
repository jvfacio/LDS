<%--
    Document   : createLoan.jsp
    Created on : Oct 4, 2016, 3:37:52 PM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Loan History" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<mvc:resources mapping="/img/**" location="/resources/img/"
    cache-period="10000" />
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <form action="create" method="post">
                <center>
                <div class="form-group">
                    <img src="<%=request.getContextPath()%>/resources/img/WP.png" height="500" width="500"/>
                </div>
                 </center>
            </form>

        </div>
        <div class="col-xs-12 col-md-8"></div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>



