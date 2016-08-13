package controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * EPAM_Project_4_WEB_APP
 * Created 8/4/16, with IntelliJ IDEA
 *
 * @author Alex
 */
@WebFilter(servletNames = {"controller"},urlPatterns = {"/*"}, filterName = "ip black list filter")
public class PermissionsFilter implements Filter {
    private final String[] ADMIN_IP_WHITE_LIST = {"192.168.1.103","127.0.0.1"};

    @Override
    public void init(FilterConfig config) throws ServletException{
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterchain) throws IOException, ServletException {
        String userip = request.getRemoteAddr();
        HttpServletResponse httpResponse = null;
        HttpServletRequest httpRequest = null;
        if (response instanceof HttpServletResponse){
            httpResponse = (HttpServletResponse) response;
        }
        if (request instanceof HttpServletRequest){
            httpRequest = (HttpServletRequest) request;
        }
        if (!httpRequest.getServletPath().contains("admin")){
            filterchain.doFilter(request, response);
        }else{
            for (String ip:ADMIN_IP_WHITE_LIST) {
                if (ip.equals(userip)) {
                    httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN,"You are not allowed to access the servlet!");
                } else {
                    filterchain.doFilter(request, response);
                }
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
