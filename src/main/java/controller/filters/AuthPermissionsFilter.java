package controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/14/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@WebFilter(servletNames = {"controller"},urlPatterns = {"/*"}, filterName = "access filter")
public class AuthPermissionsFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = null;
        HttpServletRequest httpRequest = null;
        if (servletResponse instanceof HttpServletResponse){
            httpResponse = (HttpServletResponse) servletResponse;
        }
        if (servletRequest instanceof HttpServletRequest){
            httpRequest = (HttpServletRequest) servletRequest;
        }
        if(httpRequest.getSession().getAttribute("userId")==null){
            httpResponse.sendRedirect("index.jsp");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
