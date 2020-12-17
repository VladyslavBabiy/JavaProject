package ua.filters;


import ua.model.entity.User;
import ua.model.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;
/**
 * Acidification filter.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final UserService userService = new UserService();

        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            final User.Role role = (User.Role) session.getAttribute("role");

            moveToMenu(req, res, role);

        } else if (userService.getAllUser().stream().anyMatch(x-> x.getLogin().equals(login) && x.getPassword().equals(password)))
        {
            final User.Role role = userService.getAllUser()
                    .stream()
                    .filter(x->x.getLogin().equals(login)&&x.getPassword().equals(password))
                    .findFirst()
                    .get()
                    .getRole();
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, role);

        } else {

            moveToMenu(req, res, User.Role.Unknown);
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final User.Role role)
            throws ServletException, IOException {


        if (role.equals(User.Role.Admin)) {

            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);

        } else if (role.equals(User.Role.User)) {

            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);

        } else {

            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }


    @Override
    public void destroy() {
    }

}
