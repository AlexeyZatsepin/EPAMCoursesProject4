package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/16/16, with IntelliJ IDEA
 *
 * @author Alex
 */

@WebServlet(urlPatterns = "/", name = "hello")
public class Controller extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp=request.getParameter("time");
        float delta = ((float)gc.getTimeInMillis() - Long.parseLong(timeJsp))/1_000;
        request.setAttribute("res",delta);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
