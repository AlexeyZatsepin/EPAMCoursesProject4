import dao.DataAccessObject;
import entity.Client;
import entity.CreditCard;
import entity.Payment;
import org.apache.log4j.PropertyConfigurator;
import service.DBService;

import java.util.Date;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/17/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class Main{
    public static void main(String[] args){
        PropertyConfigurator.configure("log4j.properties");
        DBService service = new DBService();
//        Client client = new Client("first","second","1234",3801,"as");

        DataAccessObject<Client> dao = service.getDAO(Client.class);
        DataAccessObject<Payment> paymentDAO = service.getDAO(Payment.class);
        DataAccessObject<CreditCard> creditDAO = service.getDAO(CreditCard.class);

        Payment payment = new Payment(100L);
        CreditCard creditCard = new CreditCard(dao.get(21),payment,"1111",111,new Date(System.currentTimeMillis()),"VISA");

        paymentDAO.insert(payment);
        creditDAO.insert(creditCard);
        //Client client = dao.get(11);
//        dao.insert(new Client("first","second","1234",3801,"as"));


        System.out.println(dao.getAll());
        //client.setAdress("fasdas");
        //dao.update(client);

        service.close();
    }
}
