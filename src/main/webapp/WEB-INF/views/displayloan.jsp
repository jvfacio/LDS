<%--
    Document   : displayloan
    Created on : Oct 7, 2016, 2:33:26 PM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Loan Report" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<body>
    <h3>
        Data: ${report.getLoan().getLoanType()};
    </h3>

</body>



<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>



