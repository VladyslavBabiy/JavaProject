<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 05/01/2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>apartment name</th>
        <th>apartment class</th>
        <th>seats number</th>
        <th>price</th>
        <th>status room</th>
    </tr>
    <tr>
        <c:forEach var="room" items="${requestScope.rooms}">
    <tr>
            <td><c:out value="${room.apartmentName}"></c:out></td>
            <td><c:out value="${room.apartmentClass}"></c:out></td>
            <td><c:out value="${room.seatsNumber}"></c:out></td>
            <td><c:out value="${room.price}"></c:out></td>
            <td><c:out value="${room.statusRoom}"></c:out></td>
        </c:forEach>
</tr>
</table>

</body>
</html>
