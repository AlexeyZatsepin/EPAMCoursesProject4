package controller.commands;


import model.service.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/31/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class LogInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //String login = request.getParameter("login");

        System.out.println(password);
        //long userId  = context.getAuthService().isValidUser(email, password);
//        if (userId<0) {
//            request.setAttribute("message", "Wrong login or password");
//            return "index.jsp";
//        }
//        request.getSession().setAttribute("userId", userId);
        return "./WEB-INF/views/userProfile.jsp";
    }
}
