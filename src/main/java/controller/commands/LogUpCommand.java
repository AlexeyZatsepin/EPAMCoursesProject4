package controller.commands;

import model.service.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/12/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class LogUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        request.getSession().invalidate();
        return "index.jsp";
    }
}
