package controller.commands;

import model.service.Context;
import org.apache.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
/**
 * EPAM_Project_4_WEB_APP
 * Created 8/6/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class SendMailCommand implements Command{
    private final static Logger log = Logger.getLogger(SendMailCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        String subj = request.getParameter("subject");
        String text = request.getParameter("message");
        String from = request.getParameter("from");
        if(subj==null||text==null||from==null){
            return "./WEB-INF/views/contact.jsp";
        }
        String to = "alexzatsepin7@gmail.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject(subj);
            message.setText(text);
            Transport.send(message);
            log.info("message sent");
            request.setAttribute("message","message was sent");
        }catch (MessagingException mex) {
            log.error(mex.toString());
            //mex.printStackTrace();
            request.setAttribute("message","error");
        }
        return "./WEB-INF/views/contact.jsp";
    }
}
