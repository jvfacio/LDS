<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <title>LDS - <c:out value="${pageTitle}"/></title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8" />

        <c:if test="${!noCss}">
            <c:if test="${!noBootstrap}">
                <c:url var="bootstrapUrl" value="/resources/css/bootstrap.css"/>
                <link href="${bootstrapUrl}" rel="stylesheet" type="text/css">

                <c:url var="styleBootstrapUrl" value="/resources/css/styleBootstrap.css"/>
                <link href="${styleBootstrapUrl}" rel="stylesheet" type="text/css">

                <c:url var="scriptsBootstrapUrl" value="/resources/js/scriptsBootstrap.js"/>
                <script type="text/javascript" src="${scriptsBootstrapUrl}"></script>
            </c:if>
            <c:url var="styleUrl" value="/resources/css/styles.css"/>
            <link href="${styleUrl}" rel="stylesheet" type="text/css">
        </c:if>
        <c:if test="${!noJs}">
            <c:if test="${!noJquery}">
                <c:url var="jqueryUrl" value="/resources/js/jquery-3.1.1.slim.min.js"/>
                <script type="text/javascript" src="${jqueryUrl}"></script>
            </c:if>
            <c:if test="${!noBootstrap}">
                <c:url var="scriptsBootstrapUrl" value="/resources/js/scriptsBootstrap.js"/>
                <script type="text/javascript" src="${scriptsBootstrapUrl}"></script>
            </c:if>
        </c:if>
        <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
        <c:if test="${!noNavBar}">
            <jsp:include page="/WEB-INF/views/includes/navbar.jsp" />
        </c:if>
        <div class="container">
            <c:if test="${message != null}">
                <div class="alert alert-success" id="message"><c:out value="${message}"/></div>
                <c:remove scope="session" var="message" />
            </c:if>
            <c:if test="${!hidePageTitle}">
                <h1 id="title"><c:out value="${pageTitle}"/></h1>
            </c:if>