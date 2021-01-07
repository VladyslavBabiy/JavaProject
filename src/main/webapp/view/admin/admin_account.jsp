<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h1>Hello ADMIN!</h1>
<a href="${pageContext.request.contextPath}/app/logout"><fmt:message key="logout"/></a>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>
