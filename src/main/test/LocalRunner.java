import model.dao.impl.ClientDAO;
import model.service.Context;
import org.apache.log4j.PropertyConfigurator;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/17/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class LocalRunner {
    public static void main(String[] args){
        PropertyConfigurator.configure("config/log4j.properties");
//        Client client = new Client("first","second","1234",3801,"as");

        Context context = Context.getInstance();

        ClientDAO dao = (ClientDAO) context.getDBService().getClientDAO();
        System.out.println(dao.get(21));
        System.out.println(dao.isValidUser("alex@gmail.com","1234"));
        context.close();
        System.out.println("finish");
    }
}
