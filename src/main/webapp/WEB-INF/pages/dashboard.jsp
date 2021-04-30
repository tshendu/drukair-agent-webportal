<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
    <title>Druk Air Agent Portal</title>
</head>
<body>

<!--================ Start Registration Area =================-->
<div class="section_gap registration_area" style="margin-bottom: 100px">
    <div class="container">
        <div class="">
            <div class="row register_form" style="padding: 0">
                <div class="col-lg-5 col-md-5" style="float:none;margin:auto;">
                    <div class="mt-10">
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="mt-10">
                                <input name="agentCode"  id="agentCode" type="text" class="" placeholder="Agent Code"
                                       autofocus="true" autocomplete="off"/>
                            </div>
                        </security:authorize>

                        <input type="text" id="startDate" name="first_name" placeholder="Start Date" required
                               onfocus="this.placeholder = ''" onblur="this.placeholder = 'Start Date'"
                               class="datepicker" autocomplete="off">
                    </div>
                    <div class="mt-10">
                        <input type="text" id="endDate" name="last_name" placeholder="End Date"
                               onfocus="this.placeholder = ''"
                               onblur="this.placeholder = 'End Date'" required
                               class="datepicker" autocomplete="off">
                    </div>
                    <div class="mt-10">
                        <button id="generateBtn" class="primary-btn">Generate Report</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!--================ End Registration Area =================-->
</body>
</html>
