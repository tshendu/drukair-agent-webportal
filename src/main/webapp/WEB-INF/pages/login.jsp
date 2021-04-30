<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value=""/>
<%--
  Created by IntelliJ IDEA.
  User: Yogen
  Date: 9/23/2020
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="icon" href="<c:url value='/assets/images/logo-drukair.png'/>" type="image/png"/>
    <title>Druk Air Agent Portal</title>
</head>

<body>
<!--================ Start Registration Area =================-->
<div class="section_gap registration_area">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 offset-3">
                <div class="register_form">
                    <h3>Login</h3>
<%--                    <form method="POST" action="${contextPath}/login" class="form_area" id="myForm">--%>
<%--                    <form method="POST" action="<c:url value='/login'>" class="form_area" id="myForm">--%>
    <form id="myForm" action="<c:url value='/login'/> " class="form-horizontal globalForm" method="post">
    <div class="row">
                            <div class="col-lg-12 form_group ${error != null ? 'has-error' : ''}">

                                <span style="color:green;"> ${message}</span>
                                <input name="username" type="text" class="" placeholder="Username"
                                        readonly onfocus="this.removeAttribute('readonly');"/>
                                <input name="password" type="password" class="" placeholder="Password" autocomplete="off"/>

                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                <span style="color:red;">${error}</span>
                            </div>
                            <div class="col-lg-12 text-center">
                                <button class="primary-btn" type="submit">Sign In</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--================ End Registration Area =================-->

</body>
</html>
