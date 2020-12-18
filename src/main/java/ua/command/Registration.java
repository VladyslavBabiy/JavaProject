package ua.command;

import ua.model.entity.User;
import ua.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;


public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String login = request.getParameter("login");
        if (!(nonNull(email) && nonNull(password)&& nonNull(login)))
        {
            return "/registration.jsp";
        }
        boolean boolEmail = email.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
//        boolean boolPassword = password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
        boolean boolPassword = true;
        boolean boolLogin = login.matches("^[а-яА-Яa-zA-Z0-9]+$");
        if(!(boolEmail&&boolPassword&&boolLogin))
        {
            request.setAttribute("invalidEmail",boolEmail);
            request.setAttribute("invalidPassword",boolPassword);
            request.setAttribute("invalidLogin",boolLogin);
            return "/registration.jsp";
        }
        UserService userService = new UserService();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setLogin(login);
        user.setRole(User.Role.User);
        userService.addUser(user);
        return "/login.jsp";
    }
}
