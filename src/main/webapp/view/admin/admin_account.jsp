<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title><fmt:message key="admin.account.title"/></title>
</head>
<body>

<h1><fmt:message key="admin.account.title"/></h1>
<a href="${pageContext.request.contextPath}/app/logout"><fmt:message key="logout"/></a>
<form action="${pageContext.request.contextPath}/app/admin/booking_request">
    <input type="hidden" name="currentPage" value="1">
    <input type="hidden" name="recordsPerPage" value="15">
    <input type="hidden" name="sortedRequest" value="seats">
    <button type="submit" class="btn btn-primary"><fmt:message key="requests"/></button>
</form>
<br>
<ul>
    <li><a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=uk"><fmt:message key="label.lang.uk"/></a></li>
</ul>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>
