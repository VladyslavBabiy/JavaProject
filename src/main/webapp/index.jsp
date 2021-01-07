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
<a href="${pageContext.request.contextPath}/app/rooms">Комнати</a>





<form action="${pageContext.request.contextPath}/app/rooms">

    <input type="hidden" name="currentPage" value="1">

    <div class="form-group col-md-4">

        <label for="records">Select records per page:</label>

        <select class="form-control" id="records" name="recordsPerPage">
            <option value="5">5</option>
            <option value="10" selected>10</option>
            <option value="15">15</option>
        </select>

    </div>

    <button type="submit" class="btn btn-primary">Submit</button>

</form>






<jsp:include page="view/templates/footer.jsp"></jsp:include>
</body>
</html>