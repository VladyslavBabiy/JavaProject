package ua.controller.command;

import ua.model.dto.UserDTO;
import ua.model.exeption.AlreadyUsedName;
import ua.model.service.Impl.UserServiceImpl;
import ua.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

public class Register implements Command {
    UserService userService;
    public Register(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        UserDTO userDTO = UserDTO.builder()
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .email(request.getParameter("email"))
                .firs_name(request.getParameter("first_name"))
                .middle_name(request.getParameter("middle_name"))
                .last_name(request.getParameter("last_name"))
                .build();
        System.out.println(userDTO);
        Validator validator = Validation.
                buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<UserDTO>> constraintViolations = validator.validate(userDTO);
        if (!constraintViolations.isEmpty()) {
            request.setAttribute("constraintViolations", constraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList()));
            return "/view/registration.jsp";
        }
        try {
            userService.addUser(userDTO);
            request.setAttribute("userRegistrationMessage", true);
        } catch (AlreadyUsedName existsException) {
            request.setAttribute("userRegistrationMessage", false);
            return "/view/login.jsp";
        }
        return "/view/registration.jsp";
    }
}
