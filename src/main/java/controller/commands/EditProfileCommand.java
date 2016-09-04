package controller.commands;

import model.dao.impl.ClientDAO;
import model.entity.Client;
import model.service.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 8/6/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class EditProfileCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        String number = request.getParameter("mobile_number");
        ClientDAO clientDAO = (ClientDAO) context.getDBService().getClientDAO();
        long id = (long) request.getSession().getAttribute("userId");
        Client client = clientDAO.get(id);
        if (!client.getPassword().equals(oldPassword)){
            request.setAttribute("message", "Wrong old password");
            request.setAttribute("user",client);
            return "jsp/userProfile.jsp";
        }
        client.setPassword(newPassword);
        client.setAdress(adress);
        client.setEmail(email);
        client.setMobileNumber(Integer.valueOf(number));
        request.setAttribute("user", client);
        return "jsp/userProfile.jsp";
    }
}
