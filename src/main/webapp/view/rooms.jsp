<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Countries</title>
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
                </tr>
                <tr>
                    <c:forEach var="room" items="${requestScope.get('rooms')}">
                <tr>
                    <td><c:out value="${room.apartmentName}"></c:out></td>
                    <td><c:out value="${room.apartmentClass}"></c:out></td>
                    <td><c:out value="${room.seatsNumber}"></c:out></td>
                    <td><c:out value="${room.price}"></c:out></td>
                    <td><c:out value="${room.statusRoom}"></c:out></td>
                    </c:forEach>
                </tr>
        </table>
    </div>

    <nav aria-label="Navigation for products">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="rooms?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
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
                                                 href="rooms?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="rooms?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</main>
<jsp:include page="templates/footer.jsp"></jsp:include>
</body>
</html>
