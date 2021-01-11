package ua.controller.command.admin;

import ua.controller.command.Command;
import ua.model.dto.BookingRequestDTO;
import ua.model.service.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class BookingRequests implements Command {
    RequestService requestService;

    public BookingRequests(RequestService requestService) {
        this.requestService = requestService;
    }
    public final static String PRICE_SQL = "SELECT  * FROM request ORDER BY PRICE LIMIT ?,?";
    public final static String SEATS_SQL = "SELECT  * FROM request INNER JOIN user ON request.USERFK = user.ID ORDER BY SEATS_NUMBER LIMIT ?,?";
    public final static String APARTMENT_CLASS_SQL = "SELECT  * FROM request INNER JOIN user ON request.USERFK = user.ID ORDER BY APARTMENT_CLASS LIMIT ?,?";
    public final static String STATUS = "SELECT  * FROM request ORDER BY STATUS_ROOM DESC LIMIT ?,?";

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sortedRequest = request.getParameter("sortedRequest");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        List<BookingRequestDTO> requests = null;
        switch (sortedRequest) {
            case "class":
                requests = requestService.findRequests(currentPage, recordsPerPage, APARTMENT_CLASS_SQL);
                break;
            case "seats":
                requests = requestService.findRequests(currentPage, recordsPerPage, SEATS_SQL);
                break;
        }
        request.setAttribute("booking_requests", requests);
        int rows = requestService.getNumberOfRows();
        int nOfPages = rows / recordsPerPage;
        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("sortedRequest", sortedRequest);
        return "/view/admin/booking_requests.jsp";
    }
}
