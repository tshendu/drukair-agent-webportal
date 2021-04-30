<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>
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
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/assets/css/flaticon.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/assets/css/themify-icons.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/assets/vendors/owl-carousel/owl.carousel.min.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/assets/vendors/nice-select/css/nice-select.css'/>"/>
    <!-- main css -->
    <link rel="stylesheet" href="<c:url value='/assets/css/style.css'/>"/>
</head>

<body>
<!--================ Start Header Menu Area =================-->
<header class="header_area">
    <div class="main_menu">

        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <a class="navbar-brand logo_h" href="/">
                    <img src="/assets/images/logo-drukair.png" alt="" style="max-height: 50px"/>
                </a>
                <h3>Drukair Agent Web Portal</h3>
                <button
                        class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <span class="icon-bar"></span> <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div
                        class="collapse navbar-collapse offset"
                        id="navbarSupportedContent"
                >
                    <ul class="nav navbar-nav menu_nav ml-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="/registration">Registration</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/changePassword">Change Password</a>
                        </li>
                        <li class="nav-item">
                            <%--                            <a class="nav-link" href="/">Login</a>--%>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>

                                <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
                            </c:if>
                        </li>


                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="container"><hr></div>
</header>
<!--================ End Header Menu Area =================-->



<!--================ Start Registration Area =================-->
<div class="section_gap_top registration_area">
    <div class="container">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>Welcome ${pageContext.request.userPrincipal.name}</h2>
        </c:if>
        Dashboard




    </div>
</div>
<!--================ End Registration Area =================-->


<!--================ Start footer Area  =================-->
<footer style="background: #1e306d; color: #ffffff; font-size: 12px; text-align: center; padding: 30px; margin-top: 20px">
    <div class="container custom-footer">
        <p>
            Copyright &copy; Druk Air Corporation Limited,
            <%
                String currentDate = new SimpleDateFormat("yyyy").format(new Date());
                out.print(currentDate);
            %>
            | All rights reserved.
        </p>
    </div>
</footer>
<!--================ End footer Area  =================-->
<script src="<c:url value='/assets/js/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/assets/js/popper.js'/>"></script>
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/assets/vendors/nice-select/js/jquery.nice-select.min.js'/>"></script>
<script src="<c:url value='/assets/vendors/owl-carousel/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/assets/js/owl-carousel-thumb.min.js'/>"></script>
<script src="<c:url value='/assets/js/jquery.ajaxchimp.min.js'/>"></script>
<script src="<c:url value='/assets/js/mail-script.js'/>"></script>
<!--gmaps Js-->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
<script src="<c:url value='/assets/js/gmaps.min.js'/>"></script>
<script src="<c:url value='/assets/js/theme.js'/>"></script>
<script type="text/javascript" src="<c:url value='/assets/script-loader.js'/>"></script>
</body>
</html>
