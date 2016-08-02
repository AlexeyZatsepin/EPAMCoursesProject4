package test;

import model.entity.Client;
import model.entity.CreditCard;
import model.entity.Payment;
import org.apache.log4j.PropertyConfigurator;
import service.Context;
import service.dao.DataAccessObject;

import java.util.Date;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/17/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class LocalRunner {
    public static void main(String[] args){
        PropertyConfigurator.configure("log4j.properties");
//        Client client = new Client("first","second","1234",3801,"as");

        Context context = Context.getInstance();

        DataAccessObject<Client> dao = context.getDBService().getClientDAO();
        DataAccessObject<Payment> paymentDAO = context.getDBService().getPaymentDAO();
        DataAccessObject<CreditCard> creditDAO = context.getDBService().getCreditCardDAO();

        Payment payment = new Payment(100L);
        CreditCard creditCard = new CreditCard(dao.get(21),payment,"1111",111,new Date(System.currentTimeMillis()),"VISA");

        paymentDAO.insert(payment);
        creditDAO.insert(creditCard);
        //Client client = service.dao.get(11);
        //service.dao.insert(new Client("first","second","1234",3801,"as"));


        //System.out.println(dao.getAll());
        //client.setAdress("fasdas");
        //service.dao.update(client);
        context.close();
    }
}
