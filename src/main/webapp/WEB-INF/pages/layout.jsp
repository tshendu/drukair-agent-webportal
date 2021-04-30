<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page session="false" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="icon" href="<c:url value='/assets/images/logo-drukair.png'/>" type="image/png"/>

    <title><sitemesh:write property="title"/></title>
    <jsp:include page="../include/css.jsp"/>
    <jsp:include page="../include/js.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div id="wrapper">

    <div id="page-wrapper">

        <sitemesh:write property='body'/>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>