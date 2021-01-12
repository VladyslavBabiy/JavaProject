<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="messages"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hotel Rooms</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
</head>

<body>
<h1><fmt:message key="request"/></h1>
<p><fmt:message key="rooms.seats"/> - <c:out value=" ${bookingRequest.seatsNumber}"></c:out></p>
<p><fmt:message key="booking.date.settlement"/> - <c:out value=" ${bookingRequest.dateEviction}"></c:out></p>
<p><fmt:message key="booking.date.eviction"/> - <c:out value=" ${bookingRequest.dateSettlement}"></c:out></p>
<p><fmt:message key="rooms.apartment_class"/> - <c:out value=" ${bookingRequest.apartmentClass}"></c:out></p>


<main class="m-3">
    <div class="row col-md-6">
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th><fmt:message key="rooms.apartment_name"/></th>
                <th><fmt:message key="rooms.apartment_class"/></th>
                <th><fmt:message key="rooms.seats"/></th>
                <th><fmt:message key="rooms.price"/> </th>
                <th><fmt:message key="rooms.status"/></th>
                <th><fmt:message key="rooms.registration"/> </th>
            </tr>
            <tr>
                <c:forEach var="room" items="${requestScope.get('rooms')}">
            <tr>
                <c:if test="${room.statusRoom=='free'}">
                    <td>${room.apartmentName}</td>
                    <td>${room.apartmentClass}</td>
                    <td>${room.seatsNumber}</td>
                    <td>${room.price}</td>
                    <td>${room.statusRoom}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/app/admin/reservation_request">
                            <input type="hidden" name="roomId" value="${room.ID}">
                            <input type="hidden" name="requestBookingId" value="${bookingRequest.ID}">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </td>
                </c:if>
                </c:forEach>
            </tr>
        </table>
    </div>

    <nav aria-label="Navigation for products">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="choose_apartments?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}&sortedRooms=${sortedRooms}&request=${bookingRequest.ID}"><fmt:message key="previous"/></a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link"
                                                 href="choose_apartments?recordsPerPage=${recordsPerPage}&currentPage=${i}&sortedRooms=${sortedRooms}&request=${bookingRequest.ID}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="choose_apartments?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}&sortedRooms=${sortedRooms}&request=${bookingRequest.ID}"><fmt:message key="next"/></a>
                </li>
            </c:if>
        </ul>
    </nav>
</main>

<form action="${pageContext.request.contextPath}/app/admin/choose_apartments">
    <input type="hidden" name="currentPage" value=${currentPage}>
    <input type="hidden" name="recordsPerPage" value="15">
    <input type="hidden" name="request" value="${bookingRequest.ID}">
    <div class="form-group col-md-4">
        <label for="sorted">Select records per page:</label>
        <select class="form-control" id="sorted" name="sortedRooms">
            <option value="price"><fmt:message key="rooms.price"/></option>
            <option value="class"><fmt:message key="rooms.apartment_class"/></option>
            <option value="seats"><fmt:message key="rooms.seats"/></option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary"><fmt:message key="sort"/></button>
</form>
<br>
<ul>
    <li><a href="?sessionLocale=en&recordsPerPage=${recordsPerPage}&currentPage=${currentPage}&sortedRooms=${sortedRooms}&request=${bookingRequest.ID}"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=uk&recordsPerPage=${recordsPerPage}&currentPage=${currentPage}&sortedRooms=${sortedRooms}&request=${bookingRequest.ID}"><fmt:message key="label.lang.uk"/></a></li>
</ul>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>
