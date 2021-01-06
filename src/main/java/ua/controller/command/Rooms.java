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
        request.setAttribute("rooms",roomService.getAll());
        List<Room> list = roomService.getAll();
        for (Room room : list) {
            System.out.println(room);
        }
        return "/view/rooms.jsp";
    }
}

