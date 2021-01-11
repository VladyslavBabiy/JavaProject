<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<div class="form">
    <h1><fmt:message key="login.title"/></h1><br>
    <form method="post" action="${pageContext.request.contextPath}/app/login">

        <input type="text" required placeholder=
        <fmt:message key="form.email"/> name="login"><br>
        <input type="password" required placeholder=
        <fmt:message key="form.password"/> name="password"><br>
        <input class="button" type="submit" value=<fmt:message key="actions.login"/>>

    </form>
</div>
<a href="${pageContext.request.contextPath}/app/logout"><fmt:message key="login.home"/></a>
<ul>
    <li><a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=uk"><fmt:message key="label.lang.uk"/></a></li>
</ul>
</body>
<jsp:include page="templates/footer.jsp"></jsp:include>
</html>