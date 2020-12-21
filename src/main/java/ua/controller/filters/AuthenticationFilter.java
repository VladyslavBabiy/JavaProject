package ua.controller.filters;
import ua.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String pathUrl = request.getRequestURL().toString();
        String userRoleAsString = request.getSession().getAttribute("role").toString();
        if (userRoleAsString == null || userRoleAsString.isEmpty()) {
            ((HttpServletResponse) servletResponse).sendRedirect("/app/login");
            return;
        }
        User.Role userRole = User.Role.valueOf(userRoleAsString);
        if (pathUrl.contains("admin") && userRole == User.Role.Admin) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if (pathUrl.contains("user") && userRole == User.Role.User) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/app/login");
        }
    }
    @Override
    public void destroy() {

    }
}
