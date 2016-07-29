import dao.DataAccessObject;
import entity.Client;
import org.apache.log4j.PropertyConfigurator;
import service.DBService;

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
        //Client client = new Client("bla",19733998,"asa");
        //Payment payment = new Payment(100L);
        //CreditCard creditCard = new CreditCard(client,payment,111,new Date(System.currentTimeMillis()),"VISA");

        DataAccessObject<Client> dao = service.getDAO(Client.class);

        Client client = dao.get(11);
        dao.insert(new Client("as",1,"as"));
        client.setAdress("fasdas");
        dao.update(client);


        service.close();
    }
}
