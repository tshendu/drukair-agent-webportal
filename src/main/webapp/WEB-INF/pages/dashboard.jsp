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
    <style>
        .label{
           padding-left: 0px;
        }
    </style>
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
                                <input name="agentCode" id="agentCode" type="text" class="" placeholder="Agent Code"
                                       autofocus="true" autocomplete="off" required/>
                            </div>
                        </security:authorize>

                        <div class="col-md-8">
                            <input type="text" name="startDate" id="startDate"
                                   class="form-control datepicker field" autocomplete="off"
                                   required placeholder="Start date">
                            <%--                                                    <input type="text" id="datetimepicker" class="form-control">--%>
                        </div>

                        <div class="col-md-8">
                            <input type="text" name="endDate" id="endDate"
                                   class="form-control datepicker field" autocomplete="off"
                                   required placeholder="End date">
                            <%--                                                    <input type="text" id="datetimepicker" class="form-control">--%>
                        </div>

                        <div class="col-md-9 row">
                            <div class="col-md-6 label">
                               <label class="left-align-p" style="text-align: left"> Special GL</label>
                            </div>

                            <div class="col-md-6">
                                <input type="checkbox" name="specialGL" id="specialGL"
                                       autocomplete="off"
                                       required>
                            </div>

                            <%--                                                    <input type="text" id="datetimepicker" class="form-control">--%>
                        </div>

<%--                        <select name="month" id="month" class="form-control" required>--%>
<%--                            <option value="">-- Select Month--</option>--%>
<%--                            <option value="1">January</option>--%>
<%--                            <option value="2">February</option>--%>
<%--                            <option value="3">March</option>--%>
<%--                            <option value="4">April</option>--%>
<%--                            <option value="5">May</option>--%>
<%--                            <option value="6">June</option>--%>
<%--                            <option value="7">July</option>--%>
<%--                            <option value="8">August</option>--%>
<%--                            <option value="9">September</option>--%>
<%--                            <option value="10">October</option>--%>
<%--                            <option value="11">November</option>--%>
<%--                            <option value="12">December</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                    <div class="mt-10">--%>
<%--                        <select id="year" class="form-control" name="year" required>--%>
<%--                            <option value="">--Select Year--</option>--%>
<%--                        </select>--%>

<%--                    </div>--%>
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
