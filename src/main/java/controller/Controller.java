package controller;

import controller.commands.Command;
import controller.commands.CommandList;
import model.service.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/16/16, with IntelliJ IDEA
 *
 * @author Alex
 */

@WebServlet(urlPatterns = {"/*","/admin/"}, name = "controller")
public class Controller extends HttpServlet{
    private Context context;

    @Override
    public void init() throws ServletException {
        context = Context.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String commandName = request.getParameter("command");
        if(commandName == null){
            commandName = "INDEX";
        }
        Command command = CommandList.valueOf(commandName).getCommand();
        String link = command.execute(request, response, context);
        request.getRequestDispatcher(link).forward(request,response);
    }


    @Override
    public void destroy() {
        super.destroy();
        context.close();
    }
}
