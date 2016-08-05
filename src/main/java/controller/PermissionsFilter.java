package controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/4/16, with IntelliJ IDEA
 *
 * @author Alex
 */

public class PermissionsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = servletRequest.getRemoteAddr();
        //TODO
    }

    @Override
    public void destroy() {

    }
}
