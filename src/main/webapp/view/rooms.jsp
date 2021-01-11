<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<main class="m-3">
    <div class="row col-md-6">
        <table class="table table-striped table-bordered table-sm">
            <tr>
                <th>apartment name</th>
                <th>apartment class</th>
                <th>seats number</th>
                <th>price</th>
                <th>status room</th>
                <th>Registration</th>
            </tr>
            <tr>
                <c:forEach var="request" items="${requestScope.get('rooms')}">
            <tr>
                <td>${request.apartmentName}</td>
                <td>${request.apartmentClass}</td>
                <td>${request.seatsNumber}</td>
                <td>${request.price}</td>
                <td>${request.statusRoom}</td>
                <td>
                    <c:choose>
                        <c:when test="${request.statusRoom=='free'}">

                            <form action="${pageContext.request.contextPath}/app/user/rooms">
                                <input type="hidden" name="apartmentName" value=${request.apartmentName}>
                                <input type="hidden" name="apartmentName" value=${request.apartmentName}>
                                <input type="hidden" name="apartmentName" value=${request.apartmentName}>
                                <input type="hidden" name="apartmentName" value=${request.apartmentName}>
                                <input type="hidden" name="apartmentName" value=${request.apartmentName}>
                                <button type="submit" class="btn btn-primary">Submit</button>

                            </form>
                        </c:when>
                    </c:choose>

                </td>
                </c:forEach>
            </tr>
        </table>
    </div>

    <nav aria-label="Navigation for products">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="rooms?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}&sortedRooms=${sortedRooms}">Previous</a>
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
                                                 href="rooms?recordsPerPage=${recordsPerPage}&currentPage=${i}&sortedRooms=${sortedRooms}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="rooms?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}&sortedRooms=${sortedRooms}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</main>

<form action="${pageContext.request.contextPath}/app/user/rooms">
    <input type="hidden" name="currentPage" value=${currentPage}>
    <div class="form-group col-md-4">
        <input type="hidden" name="recordsPerPage" value="15">
        <label for="sorted">Select records per page:</label>
        <select class="form-control" id="sorted" name="sortedRooms">
            <option value="price">Price</option>
            <option value="class">Apartment class</option>
            <option value="seats">Seats number</option>
            <option value="status">Status Room</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>

</form>

<jsp:include page="templates/footer.jsp"></jsp:include>
</body>
</html>
