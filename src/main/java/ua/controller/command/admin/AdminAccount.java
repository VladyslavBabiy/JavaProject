package ua.controller.command.admin;

import ua.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminAccount implements Command {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return "/view/admin/admin_account.jsp";
    }
}
