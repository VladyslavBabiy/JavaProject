package ua.controller.command;

import ua.model.dto.RequestDTO;
import ua.model.entity.enums.ApartmentClass;
import ua.model.service.Impl.RequestServiceImpl;
import ua.model.service.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;


public class RegisterRequest implements Command {
    RequestService requestService;
    public RegisterRequest (RequestServiceImpl requestService)
    {
        this.requestService = requestService;
    }
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        RequestDTO requestDTO = RequestDTO.builder()
                .seats_number(Long.valueOf(request.getParameter("seats_number")))
                .apartmentClass(ApartmentClass.valueOf(request.getParameter("apartment_class")))
                .dateEviction(LocalDateTime.parse(request.getParameter("eviction")))
                .dateSettlement(LocalDateTime.parse(request.getParameter("settlement")))
                .build();
        System.out.println(requestDTO);
        Validator validator = Validation.
                buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RequestDTO>> constraintViolations = validator.validate(requestDTO);
        if (!constraintViolations.isEmpty()) {
            request.setAttribute("constraintViolations", constraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList()));
            System.out.println("false operation");
            return "/view/user/booking_request.jsp";
        }
        System.out.println("true");
        requestService.addRequest(requestDTO);
        return "/view/user/user_account.jsp";
    }
}
