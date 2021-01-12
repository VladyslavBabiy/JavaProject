<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="user.account.title"/></title>

</head>
<body>

<h1><fmt:message key="user.account.title"/></h1>
<a href="${pageContext.request.contextPath}/app/logout"><fmt:message key="logout"/></a>
<br>
<a href="${pageContext.request.contextPath}/app/user/booking_request"><fmt:message key="booking"/> </a>
<br>
<a href="${pageContext.request.contextPath}/app/user/pay_booking"><fmt:message key="user.account.pay"/></a>


<form action="${pageContext.request.contextPath}/app/user/rooms">

    <input type="hidden" name="currentPage" value="1">
    <input type="hidden" name="recordsPerPage" value="15">
    <input type="hidden" name="sortedRooms" value="price">
    <button type="submit" class="btn btn-primary"><fmt:message key="user.account.rooms"/></button>
</form>
<br>
<ul>
    <li><a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=uk"><fmt:message key="label.lang.uk"/></a></li>
</ul>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>
