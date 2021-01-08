package ua.controller.command.user;


import ua.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class BookingRequestForm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return "/view/user/booking_request_form.jsp";
    }
}
