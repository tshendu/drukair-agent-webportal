<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<STYLE type="text/css">
    label { text-align: center}
</STYLE>
<header class="header_area">
    <div class="main_menu">

        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <a class="navbar-brand logo_h" href="/">
                    <img src="<c:url value='/assets/images/logo-drukair.png'/>" alt="" style="max-height: 50px"/>
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
<%--                            <a class="nav-link" href="/dashboard">Dashboard</a>--%>
                            <a class="nav-link" href="<c:url value="/dashboard"/>">Dashboard</a>
                        </li>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item">
<%--                            <a class="nav-link" href="/registration">User Management</a>--%>
                            <a class="nav-link" href="<c:url value="/registration"/>">User Management</a>
                        </li>

                        </security:authorize>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/changePassword"/>">Change Password</a>
<%--                            <a class="nav-link" href="/changePassword">Change Password</a>--%>
                        </li>
                        <li class="nav-item">
                            <%--                            <a class="nav-link" href="/">Login</a>--%>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <form id="logoutForm" method="POST"
                                      action="<c:url value='/logout'/>">
<%--                                      action="${contextPath}/logout"--%>

                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>

                                <a class="nav-link cursor-pointer" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
                            </c:if>
                        </li>


                    </ul>
                </div>
            </div>
        </nav>
        <h5 style="text-align: center">Welcome: ${currentUser.agentName}</h5>

    </div>

    <div class="container">

        <hr>

    </div>
</header>