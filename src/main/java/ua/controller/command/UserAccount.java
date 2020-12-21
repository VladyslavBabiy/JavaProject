package ua.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserAccount implements Command{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        return "/view/user/user_account.jsp";
    }
}
