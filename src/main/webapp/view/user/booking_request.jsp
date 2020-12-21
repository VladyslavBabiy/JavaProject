<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 21/12/2020
  Time: 05:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/app/user/booking_request">
    <input type="text" required placeholder=<fmt:message key="form.email"/> name="seats_number"><br>
    <label for="apartment_class">Choose a car:</label>
    <select id="apartment_class" name="apartment_class">
        <option value="volvo">Volvo</option>
        <option value="saab">Saab</option>
        <option value="fiat">Fiat</option>
        <option value="audi">Audi</option>
    </select>
    <input type="submit">
    <input class="button" type="submit" value=<fmt:message key="actions.login"/>>
    <p>Выберите дату: <input type="date" name="calendar">
        <input type="submit" value="Отправить"></p>
</form>
</body>
</html>
