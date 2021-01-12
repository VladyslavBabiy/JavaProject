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
    <title>Admin Request</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
</head>

<body>

<main class="m-3">
    <div class="row col-md-6">
        <table class="table table-striped table-bordered table-sm" align="right">
            <tr>
                <th><fmt:message key="rooms.seats"/></th>
                <th><fmt:message key="rooms.apartment_class"/></th>
                <th><fmt:message key="form.name"/> </th>
                <th><fmt:message key="form.patronymic"/> </th>
                <th><fmt:message key="form.surname"/></th>
                <th><fmt:message key="booking.date.settlement"/> </th>
                <th><fmt:message key="booking.date.eviction"/> </th>
                <th></th>
            </tr>
            <tr>
                <c:forEach var="request" items="${requestScope.get('booking_requests')}">
            <tr>
                <td>${request.seatsNumber}</td>
                <td>${request.apartmentClass}</td>
                <td>${request.firstName}</td>
                <td>${request.middleName}</td>
                <td>${request.lastName}</td>
                <td>${request.dateSettlement}</td>
                <td>${request.dateEviction}</td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/app/admin/choose_apartments">
                    <input type="hidden" name="request" value="${request.ID}">
                    <input type="hidden" name="currentPage" value="1">
                    <input type="hidden" name="recordsPerPage" value="15">
                    <input type="hidden" name="sortedRooms" value="price">
                    <button type="submit" class="btn btn-primary"><fmt:message key="booking.confirm"/></button>
                </form>
            </td>
                </c:forEach>
            </tr>
        </table>
    </div>
    <nav aria-label="Navigation for products">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="booking_request?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}&sortedRequest=${sortedRequest}"><fmt:message key="previous"/> </a>
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
                                                 href="booking_request?recordsPerPage=${recordsPerPage}&currentPage=${i}&sortedRequest=${sortedRequest}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="booking_request?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}&sortedRequest=${sortedRequest}"><fmt:message key="next"/> </a>
                </li>
            </c:if>
        </ul>
    </nav>
</main>

<form action="${pageContext.request.contextPath}/app/admin/booking_request">
    <input type="hidden" name="currentPage" value=${currentPage}>
    <div class="form-group col-md-4">
        <input type="hidden" name="recordsPerPage" value="15">
        <label for="sorted">Select records per page:</label>
        <select class="form-control" id="sorted" name="sortedRequest">
            <option value="class"><fmt:message key="rooms.apartment_class"/> </option>
            <option value="seats"><fmt:message key="rooms.seats"/></option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary"><fmt:message key="sort"/></button>
</form>
<br>
<ul>
    <li><a href="?sessionLocale=en&recordsPerPage=${recordsPerPage}&currentPage=${currentPage}&sortedRequest=${sortedRequest}"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?sessionLocale=uk&recordsPerPage=${recordsPerPage}&currentPage=${currentPage}&sortedRequest=${sortedRequest}"><fmt:message key="label.lang.uk"/></a></li>
</ul>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>