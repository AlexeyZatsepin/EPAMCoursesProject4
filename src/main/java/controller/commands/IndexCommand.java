package controller.commands;

import model.dao.impl.ClientDAO;
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
public class IndexCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        Object userId = request.getSession().getAttribute("userId");
        if(userId == null){
            return "index.jsp";
        }else{
            ClientDAO clientDAO = (ClientDAO) context.getDBService().getClientDAO();
            request.setAttribute("user", clientDAO.get((long)userId));
            request.setAttribute("usersList", clientDAO.getAll());
            return "jsp/userProfile.jsp";
        }
    }
}
