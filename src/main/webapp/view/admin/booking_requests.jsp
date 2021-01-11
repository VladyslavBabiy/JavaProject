<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th>Seats number</th>
                <th>Apartment class</th>
                <th>User first name</th>
                <th>User middle name</th>
                <th>User last name</th>
                <th>Date settlement</th>
                <th>Date eviction</th>
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
                </c:forEach>
            </tr>
        </table>
    </div>

    <nav aria-label="Navigation for products">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="booking_request?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}&sortedRequest=${sortedRequest}">Previous</a>
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
                                         href="booking_request?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}&sortedRequest=${sortedRequest}">Next</a>
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
            <option value="price">Price</option>
            <option value="class">Apartment class</option>
            <option value="seats">Seats number</option>
            <option value="status">Status Room</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>

</form>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>