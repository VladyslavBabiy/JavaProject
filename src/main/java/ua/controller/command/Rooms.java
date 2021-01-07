package ua.controller.command;

import ua.model.entity.Room;
import ua.model.service.RoomService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class Rooms implements Command{
    private RoomService roomService;
    public Rooms (RoomService roomService){
        this.roomService = roomService;
    }
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        List<Room> rooms = roomService.findRooms(currentPage,
                recordsPerPage);

        request.setAttribute("rooms",rooms );

        int rows = roomService.getNumberOfRows();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        return "/view/rooms.jsp";
    }
}

