package ua.controller.command.admin;

import ua.controller.command.Command;
import ua.model.service.BookingService;
import ua.model.service.RequestService;
import ua.model.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ReservationRequest implements Command {
    BookingService bookingService;
    public ReservationRequest(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        Integer requestBookingId = Integer.parseInt(request.getParameter("requestBookingId"));
        Integer roomId = Integer.parseInt(request.getParameter("roomId"));
        bookingService.add(roomId,requestBookingId);
        return "redirect:/app/admin/admin_account";
    }
}
