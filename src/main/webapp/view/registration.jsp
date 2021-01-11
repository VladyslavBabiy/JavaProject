<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <meta charset="US-ASCII">
    <title>Register Page</title>
</head>
<body>
<h3></h3>
<form action="register" method="post">
    <strong><fmt:message key="form.email"/></strong>:<input type="text" name="email">
    <strong><fmt:message key="form.password"/></strong>:<input type="password" name="password">
    <strong><fmt:message key="form.login"/></strong>:<input type="text" name="login">
    <strong><fmt:message key="form.name"/></strong>:<input type="text" name="first_name">
    <strong><fmt:message key="form.patronymic"/></strong>:<input type="text" name="middle_name">
    <strong><fmt:message key="form.surname"/></strong>:<input type="text" name="last_name">
    <input type="submit" value=<fmt:message key="form.register"/>>
</form>
<br>
<p><fmt:message key="registration.registered"/></p>
<a href="${pageContext.request.contextPath}/app/login"> <fmt:message key="form.login"/> </a>
<ul>
    <li><a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=uk"><fmt:message key="label.lang.uk"/></a></li>
</ul>
</body>
<jsp:include page="templates/footer.jsp"></jsp:include>
</html>