package ua.command;


import ua.model.entity.User;
import ua.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class Login implements Command {
    UserService userService;
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final UserService userService = new UserService();
        final HttpSession session = request.getSession();
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            final User.Role role = (User.Role) session.getAttribute("role");
            return moveToMenu(request, role);
        } else if (userService.getAllUser().stream().anyMatch(x -> x.getLogin().equals(login) && x.getPassword().equals(password))) {
            final User.Role role = userService.getAllUser()
                    .stream()
                    .filter(x -> x.getLogin().equals(login) && x.getPassword().equals(password))
                    .findFirst()
                    .get()
                    .getRole();
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("role", role);
                return moveToMenu(request, role);
        } else {
                return moveToMenu(request, User.Role.Unknown);
        }
    }

    private String moveToMenu(final HttpServletRequest req,
                            final User.Role role)
            throws ServletException, IOException {
        if (role.equals(User.Role.Admin)) {

            return "/admin_menu.jsp";

        } else if (role.equals(User.Role.User)) {

            return "/user_menu.jsp";

        } else {

            return "/login.jsp";
        }
    }
}
