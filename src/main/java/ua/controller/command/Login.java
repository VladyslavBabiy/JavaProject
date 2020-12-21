package ua.controller.command;


import ua.model.entity.User;
import ua.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class Login implements Command {
    UserService userService;
    public Login(UserService userService) {
        this.userService = userService;
    }
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");
        final HttpSession session = request.getSession();
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            final User.Role role = (User.Role) session.getAttribute("role");
            return moveToMenu(request, role);
        }
        User user = userService.findByLogin(login).orElse(new User());
        if (nonNull(user.getLogin())&&nonNull(user.getPassword())
                &&user.getPassword().equals(password)&&user.getLogin().equals(login))
        {
            final User.Role role = user.getRole();
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

            return "redirect:/app/admin/admin_account";

        } else if (role.equals(User.Role.User)) {
            return "redirect:/app/user/user_account";
//            return "/view/user/user_account.jsp";

        } else {

            return "/view/login.jsp";
        }
    }
}
