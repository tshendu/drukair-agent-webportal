<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
    <title>User Management</title>
</head>
<body>
<!--================ Start Registration Area =================-->
<div class="section_gap_top registration_area">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 offset-3">
                <div class="register_form">
                    <h3>Agent Registration</h3>
                    <form id="registrationForm" action="<c:url value='/registration'/> "
                          class="form-horizontal globalForm" autocomplete="chrome-off">

                        <div class="form-group">
                            <div class="col-md-12">
                                    <label class="col-md-12 text-left required">Agent Code</label>
                                <input type="text" id="username" name="username" placeholder="Agent Code" required
                                      placeholder = 'Agent Code'
                                       class="" readonly onfocus="this.removeAttribute('readonly');">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label class="col-md-12 text-left required">Agent Name</label>
                                <input type="text" id="agentName" name="agentName"  required
                                       placeholder = 'Agent Name'
                                       class="" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                    <label class="col-md-12 text-left required">Password</label>
                                <input type="password" id="password" name="password" placeholder="Password"
                                       class="">
                            </div>
                        </div>
                        <div class="col-md-12 row">
                            <label class="col-md-12 text-left required">Status</label>
                            <label class="custom-label">
                                <input type="radio" name="status" value="true" checked>Active
                            </label>
                            <label class="custom-label">
                                <input type="radio" name="status" value="false">Inactive
                            </label>
                        </div>
                        <div class="form-group">
                            <input type="submit" id="btnSave" tabindex="4" class="primary-btn" style="padding: 0"
                                   value="Save">
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <table class="table compact stripe" id="cRtable" width="100%"
                   cellspacing="0">
                <thead>
                <tr>
                    <th class="hidden">Sl No.</th>
                    <th>Agent Code</th>
                    <th>Agent Name</th>
                    <th>Status</th>
                    <th width="10%"></th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
