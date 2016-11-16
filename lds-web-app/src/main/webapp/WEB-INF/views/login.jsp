<%-- 
    Document   : login.jsp
    Created on : Oct 6, 2016, 11:29:50 AM
    Author     : Training
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Login" scope="request"/>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <form action="login" method="post">
                <div class="form-group">
                    <label for="custNickname">Nickname</label>
                    <input type="text" class="form-control" id="custNickname" name="nickname" placeholder="Nickname" required="true">
                </div>
                <div class="form-group">
                    <label for="custPassword">Password</label>
                    <input type="password" class="form-control" id="custPassword" name="password" placeholder="Password" required="true">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
