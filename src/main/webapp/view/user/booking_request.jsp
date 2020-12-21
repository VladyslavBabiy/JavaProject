<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Booking room</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/app/user/booking_request" method="post">
    <input type="text" required placeholder=<fmt:message key="booking.apartment_seats_number"/> name="seats_number"><br>
    <label for="apartment_class"><fmt:message key="booking.choose_apartment"/>:</label>
    <select id="apartment_class" name="apartment_class">
        <option value="Apartment"><fmt:message key="booking.apartment_class.apartment"/></option>
        <option value="Bedroom"><fmt:message key="booking.apartment_class.bedroom"/></option>
        <option value="DeLuxe"><fmt:message key="booking.apartment_class.delixe"/></option>
        <option value="Standard"><fmt:message key="booking.apartment_class.standard"/></option>
        <option value="Suite"><fmt:message key="booking.apartment_class.suite"/></option>
    </select>
    <p><fmt:message key="booking.choose_date.settlement"/>: <input type="date" name="calendar">
    <p><fmt:message key="booking.choose_date.eviction"/>: <input type="date" name="calendar">
        <input class="button" type="submit" value=<fmt:message key="booking.request"/>>
</form>
</body>
</html>
