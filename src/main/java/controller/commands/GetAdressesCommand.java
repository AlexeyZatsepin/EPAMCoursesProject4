package controller.commands;

import model.service.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/13/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class GetAdressesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        return "./WEB-INF/views/adresses.jsp";
    }
}
