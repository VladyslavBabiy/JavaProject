<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>

<html lang="${lang}">
<head>
    <title>Hotel</title>
</head>
<body>
<h2>
    <fmt:message key="index.mainPage"/>
</h2>

<br/>
<a href="${pageContext.request.contextPath}/app/login"><fmt:message key="form.login"/> </a>
<br/>
<a href="${pageContext.request.contextPath}/app/registration"><fmt:message key="index.registration"/> </a>
<br>
<a href="${pageContext.request.contextPath}/app/exception"><fmt:message key="index.exception"/> </a>
<h2>
    <fmt:message key="index.chooseRequestLocale"/>
</h2>
<p>
    <fmt:message key="index.requestLocaleContent"/>
</p>
<p>
    <fmt:message key="index.changeLang"/>
</p>
<ul>
    <li><a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=uk"><fmt:message key="label.lang.uk"/></a></li>
</ul>
<form action="${pageContext.request.contextPath}/app/index">
    <p>Выберите дату: <input type="date" name="calendar">
        <input type="submit" value="Отправить"></p>
</form>
</body>
</html>