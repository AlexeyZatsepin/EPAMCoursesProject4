package controller;

import controller.commands.Command;
import controller.commands.CommandList;
import model.service.Context;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static model.Constants.LOG4J_CONFIG_FILE;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/16/16, with IntelliJ IDEA
 *
 * @author Alex
 */

@WebServlet(urlPatterns = {"/", "/admin"}, name = "controller")
public class Controller extends HttpServlet{
    private Context context;
    private final static Logger logger = Logger.getLogger(Controller.class);

    @Override
    public void init() throws ServletException {
        PropertyConfigurator.configure(LOG4J_CONFIG_FILE);
        context = Context.getInstance();
        logger.info("init controller");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter("command");
        logger.info(commandName);
        Command command = CommandList.valueOf(commandName).getCommand();
        String link = command.execute(request, response,context);
        request.getRequestDispatcher(link).forward(request,response);
    }

    @Override
    public void destroy() {
        super.destroy();
        context.close();
        logger.info("destroy controller");
    }
}
