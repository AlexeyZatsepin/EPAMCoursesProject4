package controller.commands;

import model.service.Context;
import org.apache.log4j.Logger;

import javax.mail.*;
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
public class SendMailCommand implements Command {
    private final static Logger log = Logger.getLogger(SendMailCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        String subj = request.getParameter("subject");
        String text = request.getParameter("message");
        String from = request.getParameter("from");
        if(subj==null||text==null||from==null){
            return "jsp/contact.jsp";
        }
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
        MailThread mailThread = new MailThread(from,subj,text,properties);
        mailThread.start();
        return "jsp/contact.jsp";
    }


    public class MailThread extends Thread{
        private MimeMessage message;
        private String to;
        private String mailSubject;
        private String mailText;
        private Properties properties;

        public MailThread(String to, String mailSubject, String mailText, Properties properties) {
            this.to = to;
            this.mailSubject = mailSubject;
            this.mailText = mailText;
            this.properties = properties;
        }

        private void init(){
            Session mailSession = createSession();
            mailSession.setDebug(true);
            message = new MimeMessage(mailSession);
            try{
                message.setSubject(mailSubject);
                message.setContent(mailText,"text/html");
            }catch (MessagingException e) {
                e.printStackTrace();//TODO log
            }
        }

        @Override
        public void run() {
            init();
            try {
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();//TODO log
            }
        }

        public Session createSession(){
            String host = properties.getProperty("mail.smpt.host");
            String port = properties.getProperty("mail.smpt.port");
            final String userName = properties.getProperty("mail.user.name");
            final String userPassword = properties.getProperty("mail.user.password");

            Properties sessionProps = new Properties();
            sessionProps.setProperty("mail.transport.protocol","smpt");
            sessionProps.setProperty("mail.host",host);
            sessionProps.put("mail.smpt.auth",true);
            sessionProps.put("mail.smpt.port",port);
            sessionProps.put("mail.smpt.socketFactory.port",port);
            sessionProps.put("mail.smpt.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            sessionProps.put("mail.smpt.socketFactory.fallback","false");
            sessionProps.setProperty("mail.smpt.quitwait","false");


            return Session.getDefaultInstance(sessionProps, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName,userPassword);
                }
            });

        }
    }
}
