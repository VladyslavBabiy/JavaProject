package ua.controller.command.admin;

import ua.controller.command.Command;
import ua.model.dto.BookingRequestDTO;
import ua.model.entity.Room;
import ua.model.service.RequestService;
import ua.model.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ChooseApartment implements Command {
    private RoomService roomService;
    private RequestService requestService;
    public final static String PRICE_SQL = "SELECT  * FROM room ORDER BY PRICE LIMIT ?,?";
    public final static String SEATS_SQL = "SELECT  * FROM room ORDER BY SEATS_NUMBER LIMIT ?,?";
    public final static String APARTMENT_CLASS_SQL = "SELECT  * FROM room ORDER BY APARTMENT_CLASS LIMIT ?,?";
    public final static String STATUS = "SELECT  * FROM room ORDER BY STATUS_ROOM DESC LIMIT ?,?";

    public ChooseApartment(RoomService roomService, RequestService requestService) {
        this.roomService = roomService;
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sortedRooms = request.getParameter("sortedRooms");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        BookingRequestDTO bookingRequestDTO = requestService.getByIdBookingRequest(Long.parseLong(request.getParameter("request"))).get();
        List<Room> rooms = null;
        switch (sortedRooms) {
            case "price":
                rooms = roomService.findRooms(currentPage, recordsPerPage, PRICE_SQL);
                break;
            case "class":
                rooms = roomService.findRooms(currentPage, recordsPerPage, APARTMENT_CLASS_SQL);
                break;
            case "seats":
                rooms = roomService.findRooms(currentPage, recordsPerPage, SEATS_SQL);
                break;
            case "status":
                rooms = roomService.findRooms(currentPage, recordsPerPage, STATUS);
                break;
        }
        request.setAttribute("rooms", rooms);

        int rows = roomService.getNumberOfRows();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }
        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("sortedRooms", sortedRooms);
        request.setAttribute("bookingRequest",bookingRequestDTO);
        return "/view/admin/choose_apartments.jsp";
    }
}
