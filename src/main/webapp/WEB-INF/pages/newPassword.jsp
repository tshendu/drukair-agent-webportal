<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <title>
        Change Password
    </title>
</head>
<body>
<!--================ Start Registration Area =================-->
<div class="section_gap registration_area">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 offset-3">
                <div class="register_form">
                    <%--                    <h3>Login</h3>--%>
                    <%--                    <p>It is high time for learning</p>--%>
                    <%--<form class="form_area"
                            id="myForm"
                            action="mail.html"
                            method="post">--%>
                    <form id="changePasswordForm" action="<c:url value='/newPassword'/> "
                          class="form-horizontal globalForm">
                        <h3>Change Password</h3>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="password" id="oldPassword" name="oldPassword" placeholder="Old Password*" required
                                       onfocus="this.placeholder = ''" onblur="this.placeholder = 'Old Password'"
                                       class="">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="password" id="password" name="password" placeholder="New Password*" required
                                       onfocus="this.placeholder = ''" onblur="this.placeholder = 'New Password'"
                                       class="">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password*" required
                                       onfocus="this.placeholder = ''" onblur="this.placeholder = 'Confirm Password'"
                                       class="">
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="submit" id="btnSave" tabindex="4" class="primary-btn" style="padding: 0"
                                   value="Save">
                            <%--                            <button id="btnSave" type="button">save</button>--%>
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
